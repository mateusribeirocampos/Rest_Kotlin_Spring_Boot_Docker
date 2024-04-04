package com.br.playground3.exceptions.handler

import com.br.playground3.exceptions.ExceptionsResponse
import com.br.playground3.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

class customizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 500,
            error = "Internal Server Error",
            path = request.getDescription(false),
            method = request.getDescription(false),
            exception = ex.javaClass.name,
            exceptionMessage = ex.message!!,
            exceptionType = ex.javaClass.typeName,
            exceptionStacktrace = ex.stackTrace.toString(),
            exceptionCause = ex.cause.toString(),
            exceptionSuppressed = ex.suppressed.toString(),
            exceptionLocalized = ex.localizedMessage,
            exceptionLocalizedMessage = ex.localizedMessage,
            exceptionCauseMessage = ex.cause.toString(),
            exceptionSuppressedMessage = ex.suppressed.toString()
        )
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse> {
        val exceptionResponse = ExceptionsResponse(
            timestamp = Date(),
            message = ex.message!!,
            details = request.getDescription(false),
            status = 500,
            error = "Internal Server Error",
            path = request.getDescription(false),
            method = request.getDescription(false),
            exception = ex.javaClass.name,
            exceptionMessage = ex.message!!,
            exceptionType = ex.javaClass.typeName,
            exceptionStacktrace = ex.stackTrace.toString(),
            exceptionCause = ex.cause.toString(),
            exceptionSuppressed = ex.suppressed.toString(),
            exceptionLocalized = ex.localizedMessage,
            exceptionLocalizedMessage = ex.localizedMessage,
            exceptionCauseMessage = ex.cause.toString(),
            exceptionSuppressedMessage = ex.suppressed.toString()
        )
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}