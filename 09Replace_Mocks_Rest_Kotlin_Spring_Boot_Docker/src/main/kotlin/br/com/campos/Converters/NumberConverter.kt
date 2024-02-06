package br.com.campos.Converters

object NumberConverter {
    fun convertToDouble(strNumber: String?): Double { // Esta função é responsável por converter uma String para Double
        if (strNumber.isNullOrBlank()) return 0.0  // Esta função é responsável por converter uma String para Double
        val number = strNumber.replace(",".toRegex(), ".") // substitui a vírgula por ponto
        return if (isNumeric(number)) number.toDouble() else 0.0 //
    }

    fun isNumeric(strName: String?): Boolean {
        if (strName.isNullOrBlank()) return false
        val number = strName.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}