package com.br.playground3.repository

import com.br.playground3.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface personRepository : JpaRepository<Person, Long?> {
}