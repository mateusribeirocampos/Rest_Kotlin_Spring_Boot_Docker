package com.br.playground5.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNoFoundException(exception: String?): RuntimeException(exception) {
}