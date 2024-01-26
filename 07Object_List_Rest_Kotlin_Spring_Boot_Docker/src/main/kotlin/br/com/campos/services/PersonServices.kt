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
        logger.info("finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Mateus"
        person.lastName = "Campos"
        person.address = "Rua dos Rios, 100"
        person.gender = "Male"
        return person
    }

    fun findAll(): List<Person> {
        logger.info("finding all people!")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last Name $i"
        person.address = "some address in Brasil $i"
        person.gender = "Male"
        return person
    }
}