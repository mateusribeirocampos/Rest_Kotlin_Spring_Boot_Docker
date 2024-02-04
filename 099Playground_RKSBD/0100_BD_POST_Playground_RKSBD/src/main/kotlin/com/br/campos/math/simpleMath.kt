package com.br.campos.math

class simpleMath {

    fun sum(numberOne: Double, numberTwo: Double): Double = numberOne + numberTwo

    fun sub(numberOne: Double, numberTwo: Double): Double = numberOne - numberTwo

    fun mult(numberOne: Double, numberTwo: Double): Double = numberOne * numberTwo

    fun div(numberOne: Double, numberTwo: Double): Double = numberOne / numberTwo

    fun mean(numberOne: Double, numberTwo: Double): Double = (numberOne + numberTwo) / 2

    fun sqrt(numberOne: Double): Double = kotlin.math.sqrt(numberOne)

    fun log2(numberOne: Double): Double = kotlin.math.log2(numberOne)
}