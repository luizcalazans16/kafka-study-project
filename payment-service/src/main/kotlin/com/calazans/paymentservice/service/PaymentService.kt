package com.calazans.paymentservice.service

import com.calazans.paymentservice.model.Payment
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class PaymentService {

    companion object: KLogging()

    fun sendPayment(payment: Payment) {
        logger.info { "Payment received ::: [$payment]" }
    }
}