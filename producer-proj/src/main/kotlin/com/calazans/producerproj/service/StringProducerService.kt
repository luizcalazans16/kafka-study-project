package com.calazans.producerproj.service

import mu.KLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class StringProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private companion object : KLogging() {
        const val TOPIC_NAME = "str-topic"
    }

    fun sendMessage(message: String) {
        logger.info { "Sending message: [$message]" }
        kafkaTemplate.send(TOPIC_NAME, message)
//            .addCallback(
//            {
//                if (it != null) {
//                    logger.info { "Message sent successfully [$message]" }
//                    logger.info { "Partition: [${it.recordMetadata.partition()}]" }
//                    logger.info { "Offset: [${it.recordMetadata.offset()}]" }
//                }
//            },
//            { logger.error { "Error while sending message" } })
    }
}