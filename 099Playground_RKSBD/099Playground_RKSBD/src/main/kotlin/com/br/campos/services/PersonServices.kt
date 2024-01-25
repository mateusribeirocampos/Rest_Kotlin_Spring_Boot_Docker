package com.br.campos.services

import com.br.campos.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonServices {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Find a person by id")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Mateus"
        person.lastName = "Campos"
        person.birthday = "1981-01-01"
        person.age = 42
        person.address = "Rua dos Rios, 100"
        person.gender = "Male"
        return person
    }
}