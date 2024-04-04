package com.br.campos.exceptions

import java.util.Date

class ExceptionsResponse (
    val timestamp: Date,
    val message: String?,
    val details: String,
    val status: String
)