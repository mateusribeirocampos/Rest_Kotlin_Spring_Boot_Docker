package com.br.campos.services

import com.br.campos.exceptions.ResourceNotFoundException
import com.br.campos.model.Person
import com.br.campos.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)
    fun findAll(): List<Person> {
        logger.info("Finding one person!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found for this id $id") }
    }

    fun create(person: Person): Person {
        logger.info("Creating a new person with name ${person.firstName} ${person.lastName}!")

        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating a person with name ${person.firstName} ${person.lastName}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person not found for this id ${person.id}") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.birthday = person.birthday
        entity.age = person.age
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with id = $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found for this id = $id") }
        repository.delete(entity)
    }
}
