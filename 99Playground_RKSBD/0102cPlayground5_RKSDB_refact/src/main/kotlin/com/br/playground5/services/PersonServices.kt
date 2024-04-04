package com.br.playground5.services

import com.br.playground5.exceptions.ResourceNoFoundException
import com.br.playground5.model.Person
import com.br.playground5.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun finAll(): List<Person>{
        logger.info("Finding all people!!!")
        return repository.findAll()
    }

    fun findById(id: Long): Person{
        logger.info("Finding one person by id = ${id}!")

        return repository.findById(id)
            .orElseThrow { ResourceNoFoundException("No recordes for this ID? $id") }
    }



}