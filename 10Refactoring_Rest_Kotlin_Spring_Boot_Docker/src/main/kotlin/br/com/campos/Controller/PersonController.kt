package br.com.campos.Controller

import br.com.campos.model.Person
import br.com.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController // Esta anotação é responsável por informar ao Spring que esta classe é um RestController
@RequestMapping("/person") // Esta anotação é responsável por mapear a URL que será utilizada para acessar este Controller
class PersonController {

    @Autowired // Esta anotação é responsável por informar ao Spring que esta variável será injetada
    private lateinit var services: PersonServices

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(): List<Person> {
        return services.findAll()
    }

    @RequestMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(
        @PathVariable(value = "id") id: Long,
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
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*> {
        services.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}