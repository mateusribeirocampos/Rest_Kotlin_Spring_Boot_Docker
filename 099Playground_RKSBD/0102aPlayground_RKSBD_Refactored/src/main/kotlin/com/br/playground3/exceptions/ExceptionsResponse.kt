package com.br.playground3.exceptions

import java.util.*

class ExceptionsResponse (
    val timestamp: Date,
    val message: String,
    val details: String,
    val status: Int,
    val error: String,
    val path: String,
    val method: String,
    val exception: String,
    val exceptionMessage: String,
    val exceptionType: String,
    val exceptionStacktrace: String,
    val exceptionCause: String,
    val exceptionSuppressed: String,
    val exceptionLocalized: String,
    val exceptionLocalizedMessage: String,
    val exceptionCauseMessage: String,
    val exceptionSuppressedMessage: String
)