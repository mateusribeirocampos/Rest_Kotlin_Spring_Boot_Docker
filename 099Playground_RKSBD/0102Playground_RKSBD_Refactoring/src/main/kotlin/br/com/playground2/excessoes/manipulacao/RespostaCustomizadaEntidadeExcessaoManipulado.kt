package br.com.playground2.excessoes.manipulacao

import br.com.playground2.excessoes.RecursosNaoEncontradosExcessoes
import br.com.playground2.excessoes.respostasExcessoes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

class RespostaCustomizadaEntidadeExcessaoManipulado {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<respostasExcessoes> {
        val RespostasExcessoes = respostasExcessoes(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(RespostasExcessoes, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(RecursosNaoEncontradosExcessoes::class)
    fun handleRecursoNaoEncontrado(ex: Exception, request: WebRequest): ResponseEntity<respostasExcessoes> {
        val RespostasExcessoes = respostasExcessoes(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(RespostasExcessoes, HttpStatus.NOT_FOUND)
    }
}