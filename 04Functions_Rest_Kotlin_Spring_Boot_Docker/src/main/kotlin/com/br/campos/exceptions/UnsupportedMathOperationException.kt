package com.br.campos.exceptions

import java.lang.Exception

// classe para tratar exceções de operações matemáticas não suportadas
class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception){
}