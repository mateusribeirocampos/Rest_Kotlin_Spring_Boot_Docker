package br.com.campos.services

import br.com.campos.data.vo.v1.PersonVO
import br.com.campos.data.vo.v2.PersonVO as PersonVOV2
import br.com.campos.exceptions.ResourceNotFoundException
import br.com.campos.mapper.DozerMapper
import br.com.campos.mapper.custom.PersonMapper
import br.com.campos.model.Person
import br.com.campos.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonServices::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("finding all people!!!")
        val persons = repository.findAll()
        return DozerMapper.parseListObject(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("finding one person by id: $id")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found with id: $id") }
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating a person with a name: ${person.firstName} ${person.lastName}!")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }
    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating a person with a name: ${person.firstName} ${person.lastName}!")
        val entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating a person with a name: ${person.firstName} ${person.lastName}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Person not found with id") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }
    fun delete(id: Long) {
        logger.info("Deleting a person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found with id $id") }
        repository.delete(entity)
    }
}