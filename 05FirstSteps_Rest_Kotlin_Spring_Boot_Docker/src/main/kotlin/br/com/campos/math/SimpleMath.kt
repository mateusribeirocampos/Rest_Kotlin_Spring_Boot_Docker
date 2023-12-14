package br.com.campos.math

import org.springframework.web.bind.annotation.PathVariable

class SimpleMath {

    fun sum( numberOne: Double, numberTwo: Double): Double = numberOne + numberTwo

    fun sub( numberOne: Double, numberTwo: Double): Double = numberOne - numberTwo

    fun mult( numberOne: Double, numberTwo: Double): Double = numberOne * numberTwo

    fun divs( numberOne: Double, numberTwo: Double): Double = numberOne / numberTwo

    fun med( numberOne: Double, numberTwo: Double): Double = (numberOne + numberTwo) / 2

    fun sqrtr( numberOne: Double): Double = Math.sqrt(numberOne)

}