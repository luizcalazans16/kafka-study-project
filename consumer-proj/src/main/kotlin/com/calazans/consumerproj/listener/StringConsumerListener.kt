package com.calazans.consumerproj.listener

import com.calazans.consumerproj.custom.StringConsumerCustomListener
import mu.KLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.stereotype.Component

@Component
class StringConsumerListener {

    private companion object : KLogging()

    @StringConsumerCustomListener(groupId = "group-1")
    fun buildListener(message: String) {
        logger.info { "buildListener ::: Message received: [$message]" }
    }

    @KafkaListener(groupId = "group-2", topics = ["str-topic"], containerFactory = "validMessageContainerFactory")
    fun buildLog(message: String) {
        logger.info { "buildLog ::: Message received: [$message]" }
    }
}