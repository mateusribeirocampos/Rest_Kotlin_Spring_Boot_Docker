package com.br.campos.controller

import com.br.campos.model.Person
import com.br.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var services: PersonServices

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(): List<Person> {
        return services.findAll()
    }

    @RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(
        @PathVariable("id") id: Long
    ): Person {
        return services.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return services.create(person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        return services.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
                    produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*> {
        services.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
