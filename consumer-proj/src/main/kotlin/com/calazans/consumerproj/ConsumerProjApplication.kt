package com.calazans.consumerproj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class ConsumerProjApplication

fun main(args: Array<String>) {
	runApplication<ConsumerProjApplication>(*args)
}
