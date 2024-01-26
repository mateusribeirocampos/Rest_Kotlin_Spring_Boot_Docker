package br.com.campos.Controller

import br.com.campos.model.Person
import br.com.campos.services.PersonServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController // Esta anotação é responsável por informar ao Spring que esta classe é um RestController
@RequestMapping("/person") // Esta anotação é responsável por mapear a URL que será utilizada para acessar este Controller
class PersonController {

	@Autowired // Esta anotação é responsável por informar ao Spring que esta variável será injetada
	private lateinit var services: PersonServices


	@RequestMapping(
		value = ["/{id}"],
		method = [RequestMethod.GET],
		produces = [MediaType.APPLICATION_JSON_VALUE])

	fun findById(@PathVariable(value="id") id: Long,
	): Person {
		return services.findById(id)
	}

	@RequestMapping(
		method = [RequestMethod.GET],
		produces = [MediaType.APPLICATION_JSON_VALUE])

	fun findById(): List<Person> {
		return services.findAll()
	}
}