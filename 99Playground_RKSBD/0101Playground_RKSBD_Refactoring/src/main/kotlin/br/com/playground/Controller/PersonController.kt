package br.com.playground.Controller

import br.com.playground.model.Person
import br.com.playground.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var services: PersonServices

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(): List<Person> {
        return services.findAll()
    }

    @RequestMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long): Person {
        return services.findById(id)
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return services.create(person)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        return services.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        services.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}