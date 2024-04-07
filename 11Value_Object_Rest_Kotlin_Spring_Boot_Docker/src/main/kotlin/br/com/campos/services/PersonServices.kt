package br.com.campos.services

import br.com.campos.exceptions.ResourceNotFoundException
import br.com.campos.model.Person
import br.com.campos.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findAll(): List<Person> {
        logger.info("finding all people!!!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("finding one person by id: $id")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found with id: $id") }
    }

    fun create(person: Person): Person {
        logger.info("Creating a person with a name: ${person.firstName} ${person.lastName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating a person with a name: ${person.firstName} ${person.lastName}")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person not found with id") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }
    fun delete(id: Long) {
        logger.info("Deleting a person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found with id $id") }
        repository.delete(entity)
    }
}