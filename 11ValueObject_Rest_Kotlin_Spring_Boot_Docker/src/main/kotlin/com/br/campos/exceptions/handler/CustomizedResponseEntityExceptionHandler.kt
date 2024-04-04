package com.br.campos.exceptions.handler

import com.br.campos.exceptions.ExceptionsResponse
import com.br.campos.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            Date(),
            ex.message,
            request.getDescription(false),
            "500"
        )
        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            Date(),
            ex.message,
            request.getDescription(false),
            "500"
        )
        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.NOT_FOUND)
    }
}