package com.br.campos.controller

import com.br.campos.exceptions.UnsupportedMathOperationException
import com.br.campos.functions.NumberConverter.convertToDouble
import com.br.campos.functions.NumberConverter.isNumeric
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
        // tratamento do erro
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    @RequestMapping(value = ["/sqrt/{numberOne}"])
    fun sqrt(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if (!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return kotlin.math.sqrt(convertToDouble(numberOne))
    }

    @RequestMapping(value = ["/log2/{numberOne}"])
    fun log2(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if (!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return kotlin.math.log2(convertToDouble(numberOne))
    }
}