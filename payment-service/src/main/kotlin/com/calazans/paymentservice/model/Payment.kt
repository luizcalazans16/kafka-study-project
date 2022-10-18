package com.calazans.paymentservice.model

import java.io.Serializable
import java.util.UUID

data class Payment(
    val id: UUID,
    val userId: UUID,
    val productId: UUID,
    val cardNumber: String
) : Serializable
