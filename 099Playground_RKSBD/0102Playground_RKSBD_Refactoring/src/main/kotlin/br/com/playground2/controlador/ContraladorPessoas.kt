package br.com.playground2.controlador

import br.com.playground2.modelo.Pessoas
import br.com.playground2.servicos.ServicosPessoas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class ContraladorPessoas {

    @Autowired
    private lateinit var servicos: ServicosPessoas

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(): List<Pessoas> {
        return servicos.findAll()
    }

    @RequestMapping(value = ["/{id}"],
                    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long
    ): Pessoas {
        return servicos.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
                 produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(pessoas: Pessoas): Pessoas {
        return servicos.create(pessoas)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody pessoas: Pessoas): Pessoas {
        return servicos.update(pessoas)
    }

    @DeleteMapping(value = ["/{id}"],
                    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long) : ResponseEntity<*> {
        servicos.delete(id)
        return ResponseEntity.ok().build<Any>()
    }

}
