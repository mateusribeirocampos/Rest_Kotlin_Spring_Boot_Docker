package br.com.playground2.servicos

import br.com.playground2.repositorio.RepositorioPessoas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class ServicosPessoas {

    @Autowired
    private lateinit var repository: RepositorioPessoas

    private val logger = Logger.getLogger(ServicosPessoas::class.java.name)

}