package com.br.campos.converters

object NumberConverter {
    // Função convertToDouble para converter String em Double
    fun convertToDouble(strNumber: String?): Double {
        // Se o numero inserido for nulo ou sem numbero retorna 0.0
        if(strNumber.isNullOrBlank()) return 0.0
        // converte a virgula em .
        val number = strNumber.replace(",".toRegex(), ".")
        // retorna o numero inserido
        return if (isNumeric(number)) number.toDouble() else 0.0
    }
    // função para verificar se é um numero
    fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("[-+]?[0-9]*\\.?[0-9]+".toRegex())
    }
}