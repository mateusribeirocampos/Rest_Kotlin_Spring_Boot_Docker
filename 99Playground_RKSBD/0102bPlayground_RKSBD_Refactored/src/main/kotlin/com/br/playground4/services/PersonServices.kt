package com.br.playground4.services

import com.br.playground4.exceptions.ResourceNotFoundException
import com.br.playground4.model.Person
import com.br.playground4.repository.personRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: personRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findAll(): List<Person> {
        logger.info("finding all persons!!!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("finding person by ID: ${id}!!!")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records for this ID: $id") }
    }

    fun create(person: Person): Person {
        logger.info("creating a person with name: ${person.firstName} ${person.lastName}!!!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("updating a person with name: ${person.firstName} ${person.lastName}!!!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records for this ID: ${person.id}") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.age = person.age
        entity.address = person.address
        entity.country = person.country

        return repository.save(entity)
    }
    fun delete(id: Long) {
        logger.info("Deleting a person with id $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records for this ID: $id")}
        repository.delete(entity)
    }
}