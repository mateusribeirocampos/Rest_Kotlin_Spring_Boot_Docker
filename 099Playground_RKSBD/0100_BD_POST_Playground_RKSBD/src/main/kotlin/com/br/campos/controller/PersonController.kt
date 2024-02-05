// Importando as classes necessárias
package com.br.campos.controller

import com.br.campos.model.Person
import com.br.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

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

    // @RequestMapping é usado para mapear a URL "/person" para este método.
    @RequestMapping(
        // O método será invocado quando uma solicitação GET for feita para essa URL.
        method = [RequestMethod.GET],
        // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(): List<Person> {
        // O método chama services.findById(id) para obter uma instância de Person com o ID fornecido.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.findAll()
    }

    // @RequestMapping é usado novamente para mapear a URL "/person/{id}" para este método.
    // O método será invocado quando uma solicitação GET for feita para essa URL.
    // O valor do parâmetro {id} é capturado usando @PathVariable.
    // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable("id") id: Long
    ): Person {
        // O método chama services.findById(id) para obter uma instância de Person com o ID fornecido.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.findById(id)
    }
    // @RequestMapping é usado novamente para mapear a URL "/person" para este método.
    // O método será invocado quando uma solicitação POST for feita para essa URL.
    // O método consome uma solicitação JSON, conforme especificado por "consumes = [MediaType.APPLICATION_JSON_VALUE]".
    // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
    @RequestMapping(
        // O método será invocado quando uma solicitação POST for feita para essa URL.
        method = [RequestMethod.POST],
        // O método consome uma solicitação JSON, conforme especificado por "consumes = [MediaType.APPLICATION_JSON_VALUE]".
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
        produces = [MediaType.APPLICATION_JSON_VALUE])
    // O método recebe um objeto Person como parâmetro, que será automaticamente convertido a partir do JSON da solicitação.
    // @RequestBody é usado para indicar que o objeto Person deve ser convertido a partir do JSON da solicitação.
    fun create(@RequestBody person: Person): Person {
        // O método chama services.create(person) para criar uma nova instância de Person.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.create(person)
    }

    @RequestMapping(
        // O método será invocado quando uma solicitação PUT for feita para essa URL.
        method = [RequestMethod.PUT],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        // O método chama services.create(person) para criar uma nova instância de Person.
        // O resultado será automaticamente convertido para JSON e retornado como resposta.
        return services.update(person)
    }
    // O delete é diferente dos outros métodos, pois não retorna um objeto JSON.
    @RequestMapping(
        value = ["/{id}"],
        // O método será invocado quando uma solicitação DELETE for feita para essa URL.
        method = [RequestMethod.DELETE],
        // O método produzirá uma resposta JSON, conforme especificado por "produces = [MediaType.APPLICATION_JSON_VALUE]".
        produces = [MediaType.APPLICATION_JSON_VALUE])
    // O método recebe o ID da pessoa a ser excluída como parâmetro.
    fun delete(@PathVariable(value="id") id: Long) {
        // O método chama services.delete(id) para excluir a instância de Person com o ID fornecido.
        services.delete(id)
    }
}
