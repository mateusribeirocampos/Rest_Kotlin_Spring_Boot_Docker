package com.br.campos.controller

import com.br.campos.converter.NumberConverter
import com.br.campos.exceptions.UnsupportedMathOperationException
import com.br.campos.converter.NumberConverter.convertToDouble
import com.br.campos.converter.NumberConverter.isNumeric
import com.br.campos.math.simpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    private val math: simpleMath = simpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            // tratamento do erro
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
    @RequestMapping(value = ["/sqrt/{numberOne}"])
    fun sqrt(@PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if(!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.sqrt(NumberConverter.convertToDouble(numberOne))
    }
    @RequestMapping(value = ["/log2/{numberOne}"])
    fun log2(@PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if(!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Por favor, insira um número válido!\nPlease set a numeric value!")
        return math.log2(NumberConverter.convertToDouble(numberOne))
    }
}