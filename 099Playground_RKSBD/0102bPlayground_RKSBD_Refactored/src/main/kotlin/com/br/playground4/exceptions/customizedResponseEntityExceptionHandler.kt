package com.br.playground4.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

class customizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<exceptionsResponse> {
        val exceptionsResponse = exceptionsResponse(
            timestamp = Date().toString(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 500,
            error = "HTTP 500 - Internal Server Error"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(resourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<exceptionsResponse> {
        val exceptionsResponse = exceptionsResponse(
            timestamp = Date().toString(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 404,
            error = "HTTP 404 - Not Found"
        )
        return ResponseEntity(exceptionsResponse, HttpStatus.NOT_FOUND)
    }
}