package com.calazans.paymentservice.controller

import com.calazans.paymentservice.model.Payment
import com.calazans.paymentservice.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping
    fun sendPayment(@RequestBody payment: Payment) : ResponseEntity<Payment> {
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}