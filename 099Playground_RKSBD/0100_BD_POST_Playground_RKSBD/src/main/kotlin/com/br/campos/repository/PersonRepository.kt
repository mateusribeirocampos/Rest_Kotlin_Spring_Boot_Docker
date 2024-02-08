package com.br.campos.repository

import com.br.campos.model.Person
import org.springframework.data.jpa.repository.JpaRepository

//@Repository - não é mais necessário pois a anotação @Repository já está presente na interface JpaRepository
interface PersonRepository : JpaRepository<Person, Long?> {
}