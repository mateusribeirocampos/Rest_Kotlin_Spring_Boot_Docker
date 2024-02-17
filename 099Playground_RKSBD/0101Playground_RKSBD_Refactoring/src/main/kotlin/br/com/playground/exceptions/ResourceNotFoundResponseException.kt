package br.com.playground.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.*

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundResponseException(exception: String) : RuntimeException(exception){
}