package com.br.playground4.exceptions

import java.util.*

class ExceptionsResponse(
    val timestamp: Date,
    val message: String,
    val details: String,
    val status: Int,
    val error: String
)