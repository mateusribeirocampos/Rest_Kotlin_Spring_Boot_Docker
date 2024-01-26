// Importando as classes necessárias
package com.br.campos.controller

import com.br.campos.model.Person
import com.br.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

// @RestController é uma anotação do Spring que combina a funcionalidade de @Controller e @ResponseBody.
// Isso significa que esta classe é um controlador REST e as respostas dos métodos são automaticamente convertidas para JSON.
@RestController
//
// @RequestMapping é uma anotação que mapeia URLs para métodos de controlador. Neste caso, todas as URLs começarão com "/person".
@RequestMapping("/person")
class PersonController {

    // @Autowired é uma anotação do Spring que injeta automaticamente a instância de PersonServices.
    // Isso significa que você não precisa criar manualmente uma instância de PersonServices, o Spring fará isso por você.
    @Autowired
    lateinit var services: PersonServices

    // @RequestMapping é usado novamente para mapear a URL "/person/{id}" para este método.
    // O método será invocado quando uma solicitação GET for feita para essa URL.
    // O valor do parâmetro {id} é capturado usando @PathVariable.
    // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable("id") id: Long): Person {
        // O método chama services.findById(id) para obter uma instância de Person com o ID fornecido.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.findById(id)
    }

    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(): List<Person> {
        // O método chama services.findById(id) para obter uma instância de Person com o ID fornecido.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.findAll()
    }
}
