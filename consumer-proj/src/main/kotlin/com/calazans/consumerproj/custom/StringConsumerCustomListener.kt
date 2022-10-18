package com.calazans.consumerproj.custom

import org.springframework.core.annotation.AliasFor
import org.springframework.kafka.annotation.KafkaListener

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@KafkaListener
annotation class StringConsumerCustomListener(
    @get:AliasFor(annotation = KafkaListener::class, attribute = "topics")
    val topics: Array<String> = ["str-topic"],
    @get:AliasFor(annotation = KafkaListener::class, attribute = "containerFactory")
    val containerFactory: String = "stringContainerFactory",
    @get:AliasFor(annotation = KafkaListener::class, attribute = "groupId")
    val groupId: String = "",
    @get:AliasFor(annotation = KafkaListener::class, attribute = "errorHandler")
    val errorHandler: String = "customErrorHandler"
)