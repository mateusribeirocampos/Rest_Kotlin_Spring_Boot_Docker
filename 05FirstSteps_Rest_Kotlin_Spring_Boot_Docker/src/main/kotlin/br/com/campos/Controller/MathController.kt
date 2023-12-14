package br.com.campos.Controller

import br.com.campos.Converters.NumberConverter
import br.com.campos.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController // Esta anotação é responsável por informar ao Spring que esta classe é um RestController
class MathController {

	val counter: AtomicLong = AtomicLong() // Esta variável é responsável por contar quantas requisições foram feitas

	private val math: SimpleMath = SimpleMath() // Esta variável é responsável por instanciar a classe SimpleMath

		// RequestMapping = usada para mapear a URL que será utilizada para acessar este método
	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}/"]) // Esta anotação é responsável por mapear a URL que será utilizada para acessar este método
			/*PathVariable = usada para recuperar dados da URL - permite controle lide com requisições parametrizadas*/
	fun sum(@PathVariable(value="numberOne") numberOne: String?, // Esta anotação é responsável por informar ao Spring que este parâmetro será recebido da URL
            @PathVariable(value="numberTwo") numberTwo: String? // Esta anotação é responsável por informar ao Spring que este parâmetro será recebido da URL
	): Double { // Esta anotação é responsável por informar ao Spring que este método retornará um Double
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw Exception("Please set a numeric value!")
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
	}

	@RequestMapping(value = ["/sub/{numberOne}/{numberTwo}/"])
	fun sub(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw Exception("Please set a numeric value!")
		return math.sub(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo))
	}

	@RequestMapping(value = ["/mult/{numberOne}/{numberTwo}/"])
	fun mult(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw Exception("Please set a numeric value!")
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
	}

	@RequestMapping(value = ["/divs/{numberOne}/{numberTwo}/"])
	fun divs(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw Exception("Please set a numeric value!")
		return math.divs(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
	}

	@RequestMapping(value = ["/med/{numberOne}/{numberTwo}/"])
	fun med(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
	): Double {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
			throw Exception("Please set a numeric value!")
		return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
	}

	@RequestMapping(value = ["/sqrtr/{numberOne}/"])
	fun sqrtr(@PathVariable(value="numberOne") numberOne: String?
	): Double {
		if (!NumberConverter.isNumeric(numberOne))
			throw Exception("Please set a numeric value!")
		return math.sqrtr(NumberConverter.convertToDouble(numberOne))
	}
}