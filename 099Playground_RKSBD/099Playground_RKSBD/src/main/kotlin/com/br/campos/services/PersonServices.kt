// Importando as classes necessárias
package com.br.campos.services

import com.br.campos.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

// @Service é uma anotação do Spring que marca essa classe como um serviço.
// Isso significa que o Spring gerenciará automaticamente a criação e a injeção de instâncias dessa classe.
@Service
class PersonServices {

    // Um contador atômico para gerar IDs únicos.
    private val counter: AtomicLong = AtomicLong()

    // Um logger para registrar mensagens. Neste caso, está configurado para logar mensagens para a classe PersonServices.
    private val logger = Logger.getLogger(PersonServices::class.java.name)
    fun findAll(): List<Person> {
        // Registrando uma mensagem de log informando que está procurando uma pessoa pelo ID.
        logger.info("Finding one person!")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..10){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }
    // Método para encontrar uma pessoa pelo ID.
    fun findById(id: Long): Person {
        // Registrando uma mensagem de log informando que está procurando uma pessoa pelo ID.
        logger.info("Finding one person!")

        // Criando uma instância de Person com dados fictícios.
        val person = Person()
        person.id = counter.incrementAndGet() // Aumentando o contador e atribuindo o valor como ID da pessoa.
        person.firstName = "Mateus"
        person.lastName = "Campos"
        person.birthday = "1981-01-01"
        person.age = 42
        person.address = "Rua dos Rios, 100"
        person.gender = "Male"

        // Retornando a instância de Person criada.
        return person
    }

    // Método para criar uma nova pessoa.
    fun create(person: Person): Person {
        // Registrando uma mensagem de log informando que está criando uma nova pessoa.
        logger.info("Creating a new person!")

        // Retornando a instância de Person recebida.
        return person
    }

    // Método para atualizar uma pessoa existente.
    fun update(person: Person): Person {
        // Registrando uma mensagem de log informando que está atualizando uma pessoa.
        logger.info("Updating a person!")

        // Retornando a instância de Person recebida.
        return person
    }

    // Método para excluir uma pessoa pelo ID.
    fun delete(id: Long) {
        // Registrando uma mensagem de log informando que está excluindo uma pessoa pelo ID.
        logger.info(("Deleting a person by ID!"))

        // Não faz nada.
    }

    private fun mockPerson(i: Int): Person {
        // Criando uma instância de Person com dados fictícios.
        val person = Person()
        person.id = counter.incrementAndGet() // Aumentando o contador e atribuindo o valor como ID da pessoa.
        person.firstName = "First Name $i"
        person.lastName = "Last Name $i"
        person.birthday = "1981-01-01"
        person.age = 42
        person.address = "Rua dos Rios, $i+1"
        person.gender = "Male"

        // Retornando a instância de Person criada.
        return person
    }
}
