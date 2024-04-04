package com.br.campos.exceptions

import java.lang.*
import kotlin.RuntimeException

// classe para tratar exceções de operações matemáticas não suportadas
class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception) {


}