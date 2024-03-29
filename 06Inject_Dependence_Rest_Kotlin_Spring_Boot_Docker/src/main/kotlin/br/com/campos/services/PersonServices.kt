package br.com.campos.services

import br.com.campos.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service // Esta anotação é responsável por informar ao Spring que esta classe é um Service
class PersonServices {

    private val counter: AtomicLong = AtomicLong()

    // Esta variável é responsável por instanciar a classe SimpleMath
    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findById(id: Long): Person {
        logger.info("find a person by id")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Mateus"
        person.lastName = "Campos"
        person.address = "Rua dos Rios, 100"
        person.gender = "Male"
        return person
    }
}