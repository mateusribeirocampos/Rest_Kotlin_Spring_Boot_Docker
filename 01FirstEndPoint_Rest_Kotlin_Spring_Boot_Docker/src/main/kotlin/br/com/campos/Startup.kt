package br.com.campos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication  //application spring boot
class Startup


fun main(args: Array<String>) {
	runApplication<Startup>(*args)
}
