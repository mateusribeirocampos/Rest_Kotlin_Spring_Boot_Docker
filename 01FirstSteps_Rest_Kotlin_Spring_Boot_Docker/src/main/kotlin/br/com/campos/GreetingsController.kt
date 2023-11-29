package br.com.campos

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController // Esta anotação é responsável por informar ao Spring que esta classe é um RestController
class GreetingsController {

    val counter: AtomicLong = AtomicLong() // Esta variável é responsável por contar quantas requisições foram feitas

    @RequestMapping("/greetings") // Esta anotação é responsável por mapear a URL que será utilizada para acessar este método
    fun greetings(@RequestParam(value = "name", defaultValue = "Mateus") name: String?): Greetings { // Este método é responsável por retornar um objeto do tipo Greetings
        return Greetings(counter.incrementAndGet(), "Hello, $name") // Este método retorna um objeto do tipo Greetings
    }
}