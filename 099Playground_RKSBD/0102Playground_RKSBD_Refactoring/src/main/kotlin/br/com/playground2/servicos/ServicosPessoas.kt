package br.com.playground2.servicos

import br.com.playground2.modelo.Pessoas
import br.com.playground2.repositorio.RepositorioPessoas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class ServicosPessoas {

    @Autowired
    private lateinit var repositorio: RepositorioPessoas

    private val logger = Logger.getLogger(ServicosPessoas::class.java.name)

    fun findAll(): List<Pessoas> {
        logger.info("Encontrando todas as pessoas")
        return repositorio.findAll()
    }

    fun findById(id: Long): Pessoas {
        logger.info("Encontrando pessoa por id")
        return repositorio.findById(id)
            .orElseThrow( { NoSuchElementException("Pessoa com id $id não encontrada!") })
    }

    fun create(pessoas: Pessoas): Pessoas {
        logger.info("Criando uma pessoa com o nome ${pessoas.nome} ${pessoas.sobrenome}!")
        return repositorio.save(pessoas)
    }

    fun update(pessoas: Pessoas): Pessoas {
        logger.info("Atualizando pessoa com o nome ${pessoas.nome} ${pessoas.sobrenome}!")
        val entity = repositorio.findById(pessoas.id)
            .orElseThrow ({ NoSuchElementException("Pessoa com id ${pessoas.id} não encontrada!") })

        entity.nome = pessoas.nome
        entity.sobrenome = pessoas.sobrenome
        entity.sexo = pessoas.sexo
        entity.idade = pessoas.idade
        entity.email = pessoas.email
        entity.telefone = pessoas.telefone
        entity.endereco = pessoas.endereco
        entity.cidade = pessoas.cidade
        entity.estado = pessoas.estado
        entity.pais = pessoas.pais
        entity.cep = pessoas.cep

        return repositorio.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deletando pessoa com id $id")
        val entity = repositorio.findById(id)
            .orElseThrow()
        repositorio.delete(entity)
    }
}