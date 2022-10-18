package com.calazans.consumerproj.config

import mu.KLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.RecordInterceptor

@Configuration
class StringConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    companion object : KLogging()

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val configs: Map<String, Any> = hashMapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
        )
        return DefaultKafkaConsumerFactory(configs)
    }

    @Bean
    fun stringContainerFactory(consumerFactory: ConsumerFactory<String, String>): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory =
            ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory

        return factory
    }

    @Bean
    fun validMessageContainerFactory(consumerFactory: ConsumerFactory<String, String>): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory =
            ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory
        factory.setRecordInterceptor(validateMessage())

        return factory
    }

    private fun validateMessage(): RecordInterceptor<String, String> {
        return RecordInterceptor { record ->
            if (record.value().contains("Teste")) {
                logger.info { "Has the valid word" }
                return@RecordInterceptor record
            }
            record
        }
    }


}