// Importando as classes necessárias
package com.br.campos.services

import com.br.campos.exceptions.ResourceNotFoundException
import com.br.campos.model.Person
import com.br.campos.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import java.util.logging.Logger

// @Service é uma anotação do Spring que marca essa classe como um serviço.
// Isso significa que o Spring gerenciará automaticamente a criação e a injeção de instâncias dessa classe.
@Service
class PersonServices {

    @Autowired
    // lateinit é uma palavra-chave do Kotlin que indica que a variável será inicializada posteriormente.
    private lateinit var repository: PersonRepository // Atributo para acessar o repositório de pessoas.

    // Um logger para registrar mensagens. Neste caso, está configurado para logar mensagens para a classe PersonServices.
    private val logger = Logger.getLogger(PersonServices::class.java.name)
    fun findAll(): List<Person> {
        // Registrando uma mensagem de log informando que está procurando uma pessoa pelo ID.
        logger.info("Finding one person!")
        return repository.findAll()
    }
    // Método para encontrar uma pessoa pelo ID.
    fun findById(id: Long): Person {
        // Registrando uma mensagem de log informando que está procurando uma pessoa pelo ID.
        logger.info("Finding one person!")

        // Retornando a instância de Person encontrada pelo ID.
        return repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found for this id $id") }
    }

    // Método para criar uma nova pessoa.
    fun create(person: Person): Person {
        // Registrando uma mensagem de log informando que está criando uma nova pessoa.
        logger.info("Creating a new person with name ${person.firstName} + ${person.lastName}!")

        // Retornando a instância de Person recebida.
        return repository.save(person)
    }

    // Método para atualizar uma pessoa existente.
    fun update(person: Person) : Person {
        logger.info("Updating a person with name ${person.firstName} + ${person.lastName}!")
        val entity = repository.findById(person.id)
            .orElseThrow{ ResourceNotFoundException("Person not found for this id $id") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.birthday = person.birthday
        entity.age = person.age
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    // Método para excluir uma pessoa pelo ID.
    fun delete(id: Long) {
        logger.info("Deleting a person with id = $id!")
        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Person not found for this id $id") }
        repository.delete(entity)
    }


}
