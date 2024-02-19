package br.com.playground2.excessoes

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RecursosNaoEncontradosExcessoes(excessoes: String?) : RuntimeException(excessoes) {
}