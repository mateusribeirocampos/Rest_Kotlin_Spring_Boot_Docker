package com.br.campos.controller

import com.br.campos.model.Person
import com.br.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var services: PersonServices

    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable("id") id: Long): Person {
        return services.findById(id)
    }
}