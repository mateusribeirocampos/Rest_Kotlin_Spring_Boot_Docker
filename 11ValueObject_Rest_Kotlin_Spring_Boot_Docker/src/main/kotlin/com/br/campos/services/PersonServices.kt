package com.br.campos.services

import com.br.campos.exceptions.ResourceNotFoundException
import com.br.campos.data.vo.v1.PersonVO
import com.br.campos.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findAll(): List<PersonVO>{
        logger.info("Finding all people!!!")
        return repository.findAll()
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person!!!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID: $id") }
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating on person with name ${person.firstName} ${person.lastName} and ID: ${person.id}")
        return repository.save(person)
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating on person with name ${person.firstName} ${person.lastName} and ID: ${person.id}")
        val entity = repository.findById(person.id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID: ${person.id}")}

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.age = person.age
        entity.address = person.address
        entity.state = person.state
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID: $id!")
        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID: $id")}
        repository.delete(entity)
    }
}