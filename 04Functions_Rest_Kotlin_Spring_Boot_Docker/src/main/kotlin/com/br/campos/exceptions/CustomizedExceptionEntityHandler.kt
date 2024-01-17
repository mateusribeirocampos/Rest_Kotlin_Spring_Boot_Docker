package com.br.campos.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice // indica que é um controlador de exceções
@RestController // indica que é um controlador de requisições
// classe para tratar exceções personalizadas
class CustomizedExceptionEntityHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class) // ExceptionHandler indica que é uma função para tratar exceções
    fun handleAllExceptions(ex: Exception, request: WebRequest) : // função para tratar exceções específicas
            ResponseEntity<ExceptionResponse> { // retorna um objeto do tipo ResponseEntity<ExceptionResponse>
        val exceptionResponse = ExceptionResponse( // cria um objeto do tipo ExceptionResponse
            Date(), // data atual
            ex.message, // mensagem da exceção
            request.getDescription(false), // descrição da exceção
            status = HttpStatus.INTERNAL_SERVER_ERROR.value() // status da exceção
        )
        // retorna o erro 500 (INTERNAL_SERVER_ERROR)
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
    // ExceptionHandler indica que é uma função para tratar exceções
    @ExceptionHandler(UnsupportedMathOperationException::class) // UnsupportedMathOperationException indica que é uma função para tratar exceções
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest) : // função para tratar exceções específicas
            ResponseEntity<ExceptionResponse> { // retorna um objeto do tipo ResponseEntity<ExceptionResponse>
        val exceptionResponse = ExceptionResponse( // cria um objeto do tipo ExceptionResponse
            Date(),
            ex.message,
            request.getDescription(false),
            status = HttpStatus.BAD_REQUEST.value() // status da exceção (BAD_REQUEST)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST)
    }
}