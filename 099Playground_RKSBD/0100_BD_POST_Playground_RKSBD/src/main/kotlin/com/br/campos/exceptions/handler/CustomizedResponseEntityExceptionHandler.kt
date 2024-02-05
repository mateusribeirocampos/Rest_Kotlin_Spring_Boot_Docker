package com.br.campos.exceptions.handler

import com.br.campos.exceptions.ExceptionResponse
import com.br.campos.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.*

@ControllerAdvice // indica que é um controlador de exceções
@RestController // indica que é um controlador de requisições
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    // ExceptionHandler indica que é uma função para tratar exceções
    @ExceptionHandler(Exception::class)
    // função para tratar exceções específicas
    fun handleAllExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> { // retorna um objeto do tipo ResponseEntity<ExceptionResponse>
        val exceptionResponse = ExceptionResponse( // cria um objeto do tipo ExceptionResponse
            Date(),  // data atual
            ex.message,  // mensagem da exceção
            request.getDescription(false), // descrição da exceção
            status = HttpStatus.INTERNAL_SERVER_ERROR.value() // status da exceção
        )
        return ResponseEntity<ExceptionResponse>(
            exceptionResponse,
            HttpStatus.INTERNAL_SERVER_ERROR
        ) // retorna o erro 500 (INTERNAL_SERVER_ERROR)
    }

    // ExceptionHandler indica que é uma função para tratar exceções
    @ExceptionHandler(ResourceNotFoundException::class)
    // função para tratar exceções específicas
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest) :
            ResponseEntity<ExceptionResponse> { // retorna um objeto do tipo ResponseEntity<ExceptionResponse>
        val exceptionResponse = ExceptionResponse( // cria um objeto do tipo ExceptionResponse
            Date(),  // data atual
            ex.message,  // mensagem da exceção
            request.getDescription(false), // descrição da exceção
            status = HttpStatus.NOT_FOUND.value() // status da exceção
        )
        return ResponseEntity<ExceptionResponse>(
            exceptionResponse,
            HttpStatus.NOT_FOUND
        ) // retorna o erro 400 (BAD_REQUEST)
    }
}