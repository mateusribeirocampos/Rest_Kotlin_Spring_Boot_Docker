package com.br.playground5.exceptions.handler

import com.br.playground5.exceptions.ExceptionsResponse
import com.br.playground5.exceptions.ResourceNoFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.handler.ResponseStatusExceptionHandler
import java.util.*

class CustomizedResponseEntityExceptionHandler : ResponseStatusExceptionHandler() {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse>{
        val exceptionsResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            error = "Internal Server Error - HTTP 500"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNoFoundException::class)
    fun handleResourceNoFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse>{
        val exceptionsResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            error = "NOT FOUND - HTTP 404"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.NOT_FOUND)
    }
}