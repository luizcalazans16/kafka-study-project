package com.calazans.paymentservice.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaAdminConfig(
    private val kafkaProperties: KafkaProperties
) {
    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: Map<String, Any> =
            hashMapOf(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers
            )

        return KafkaAdmin(configs)
    }

    @Bean
    fun buildTopics(): KafkaAdmin.NewTopics {
        return KafkaAdmin.NewTopics(
            TopicBuilder.name("payment-topic")
                .partitions(2)
                .replicas(1)
                .build()
        )
    }
}