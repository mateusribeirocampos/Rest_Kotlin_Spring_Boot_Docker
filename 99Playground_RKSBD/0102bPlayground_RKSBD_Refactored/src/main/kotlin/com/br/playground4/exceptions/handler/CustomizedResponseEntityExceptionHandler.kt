package com.br.playground4.exceptions.handler

import com.br.playground4.exceptions.ExceptionsResponse
import com.br.playground4.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 500,
            error = "HTTP 500 - Internal Server Error"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 404,
            error = "HTTP 404 - Not Found"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.NOT_FOUND)
    }
}