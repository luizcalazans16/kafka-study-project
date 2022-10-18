package com.calazans.consumerproj.exception

import mu.KLogging
import org.apache.kafka.clients.consumer.Consumer
import org.springframework.kafka.listener.KafkaListenerErrorHandler
import org.springframework.kafka.listener.ListenerExecutionFailedException
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class CustomErrorHandler : KafkaListenerErrorHandler {
    companion object: KLogging()

    override fun handleError(message: Message<*>, exception: ListenerExecutionFailedException): Any {
        logger.info { "ExceptionHandler :::::: Captured an error" }
        logger.info { "Message payload ::: [${message.payload}]" }
        return ""
    }
}