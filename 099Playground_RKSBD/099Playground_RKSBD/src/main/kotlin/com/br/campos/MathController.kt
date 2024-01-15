package com.br.campos

import com.br.campos.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import java.util.*

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            // tratamento do erro
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)

    }
    // Função convertToDouble para converter String em Double
    private fun convertToDouble(strNumber: String?): Double {
        // Se o numero inserido for nulo ou sem numbero retorna 0.0
        if(strNumber.isNullOrBlank()) return 0.0
        // converte a virgula em .
        val number = strNumber.replace(",".toRegex(), ".")
        // retorna o numero inserido
        return if (isNumeric(number)) number.toDouble() else 0.0
    }
    // função para verificar se é um numero
    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("[-+]?[0-9]*\\.?[0-9]+".toRegex())
    }

}