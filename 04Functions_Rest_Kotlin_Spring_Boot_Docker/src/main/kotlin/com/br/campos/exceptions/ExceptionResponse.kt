package com.br.campos.exceptions

import java.util.*

// java util date para pegar a data e hora do erro
// java util message para pegar a mensagem do erro
// java util details para pegar os detalhes do erro
// java util status para pegar o status do erro
class ExceptionResponse (
    val timestamp: Date,
    val message: String?,
    val details: String,
    val status: Int,
)