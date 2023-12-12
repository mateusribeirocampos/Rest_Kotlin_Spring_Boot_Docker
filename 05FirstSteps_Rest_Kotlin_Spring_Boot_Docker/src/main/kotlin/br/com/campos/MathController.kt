package br.com.campos

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController // Esta anotação é responsável por informar ao Spring que esta classe é um RestController
class MathController {

	val counter: AtomicLong = AtomicLong() // Esta variável é responsável por contar quantas requisições foram feitas
	// RequestMapping = usada para mapear a URL que será utilizada para acessar este método
	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}/"]) // Esta anotação é responsável por mapear a URL que será utilizada para acessar este método
    /*PathVariable = usada para recuperar dados da URL - permite controle lide com requisições parametrizadas*/
    fun sum(@PathVariable(value="numberOne") numberOne: String?, // Esta anotação é responsável por informar ao Spring que este parâmetro será recebido da URL
            @PathVariable(value="numberTwo") numberTwo: String? // Esta anotação é responsável por informar ao Spring que este parâmetro será recebido da URL
    ): Double { // Esta anotação é responsável por informar ao Spring que este método retornará um Double
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw Exception("Please insert a valid value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

	@RequestMapping(value = ["/sub/{numberOne}/{numberTwo}/"])
	fun sub(@PathVariable(value="numberOne") numberOne: String?,
			@PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw Exception("Please insert a valid value!")
		return convertToDouble(numberOne) - convertToDouble(numberTwo)
	}

	@RequestMapping(value = ["/mult/{numberOne}/{numberTwo}/"])
	fun mult(@PathVariable(value="numberOne") numberOne: String?,
			@PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw Exception("Please insert a valid value!")
		return convertToDouble(numberOne) * convertToDouble(numberTwo)
	}

	@RequestMapping(value = ["/div/{numberOne}/{numberTwo}/"])
	fun div(@PathVariable(value="numberOne") numberOne: String?,
			@PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw Exception("Please insert a valid value!")
		return convertToDouble(numberOne) / convertToDouble(numberTwo)
	}

	private fun convertToDouble(strNumber: String?): Double { // Esta função é responsável por converter uma String para Double
		if (strNumber.isNullOrBlank()) return 0.0  // Esta função é responsável por converter uma String para Double
		val number = strNumber.replace(",".toRegex(), ".") // substitui a vírgula por ponto
		return if (isNumeric(number)) number.toDouble() else 0.0 //
	}

	private fun isNumeric(strName: String?): Boolean {
		if (strName.isNullOrBlank()) return false
		val number = strName.replace(",".toRegex(), ".")
		return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
	}
}
