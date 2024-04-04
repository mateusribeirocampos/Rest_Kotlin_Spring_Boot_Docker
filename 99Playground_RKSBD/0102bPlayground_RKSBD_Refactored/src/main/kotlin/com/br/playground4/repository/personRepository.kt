package com.br.playground4.repository

import com.br.playground4.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface personRepository : JpaRepository<Person, Long?> {
}
