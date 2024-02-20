package com.br.playground3.services

import com.br.playground3.exceptions.ResourceNotFoundException
import com.br.playground3.model.Person
import com.br.playground3.repository.personRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class personServices {

    @Autowired
    private lateinit var repository: personRepository

    private val logger = Logger.getLogger(personServices::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Find all people!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one by id = ${id}!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records for this ID: $id") }
    }

    fun create(person: Person): Person {
        logger.info("Creating a person with name ${person.firstname} ${person.lastname}!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating a person with name ${person.firstname} ${person.lastname}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID: ${person.id}") }

        entity.firstname = person.firstname
        entity.lastname = person.lastname
        entity.age = person.age
        entity.email = person.email
        entity.phone = person.phone
        entity.address = person.address
        entity.city = person.city
        entity.state = person.state
        entity.country = person.country
        entity.postalCode = person.postalCode

        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with id $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records for this ID: $id") }
        repository.delete(entity)
    }
}