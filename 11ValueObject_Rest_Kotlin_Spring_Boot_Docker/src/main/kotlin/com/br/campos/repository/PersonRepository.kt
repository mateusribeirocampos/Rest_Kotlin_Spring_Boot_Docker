package com.br.campos.repository

import com.br.campos.data.vo.v1.PersonVO
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonVO, Long?>  {
}