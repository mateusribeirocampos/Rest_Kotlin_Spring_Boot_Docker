package br.com.playground2.repositorio

import br.com.playground2.modelo.Pessoas
import org.springframework.data.jpa.repository.JpaRepository

interface RepositorioPessoas : JpaRepository<Pessoas, Long> {
}