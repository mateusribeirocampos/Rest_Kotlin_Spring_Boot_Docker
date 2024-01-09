package br.com.campos

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController //annotation to indicate that the class is a controller
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting") //annotation to indicate that the method will be called when the /greeting path is accessed
    fun greeting(
        @RequestParam(value="name", defaultValue = "World") name: String,
        @RequestParam(value="age", defaultValue = "0") age: Int,
        @RequestParam(value="address", defaultValue = "Unknown") address: String

    ): Greeting {
        return Greeting(counter.incrementAndGet(), name, age, address)
    }
}