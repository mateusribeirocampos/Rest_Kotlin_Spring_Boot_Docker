package br.com.playground.services

import br.com.playground.exceptions.ResourceNotFoundResponseException
import br.com.playground.model.Person
import br.com.playground.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findAll(): List<Person> {
        logger.info("finding all people!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("finding one person!")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundResponseException("No records found for this ID: $id") }


    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName} ${person.lastName}!")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with name ${person.firstName} ${person.lastName}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundResponseException("No records found for this ID: ${person.id}") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.age = person.age
        entity.gender = person.gender
        entity.address = person.address
        entity.phoneNumber = person.phoneNumber
        entity.email = person.email
        entity.city = person.city
        entity.country = person.country
        entity.state = person.state
        entity.zipCode = person.zipCode
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundResponseException("No records found for this ID: $id") }
        repository.delete(entity)
    }
}