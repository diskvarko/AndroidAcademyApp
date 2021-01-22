package com.diskvarko.androidacademyapp.network

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

@Serializable
data class Details (
    val success: Boolean,

    @SerialName("status_code")
    val statusCode: Long,

    @SerialName("status_message")
    val statusMessage: String
)