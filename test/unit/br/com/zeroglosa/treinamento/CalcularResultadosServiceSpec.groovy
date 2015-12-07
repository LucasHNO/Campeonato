package br.com.zeroglosa.treinamento

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CalcularResultadosService)
class CalcularResultadosServiceSpec extends Specification {

	void "Calcula pontuanção time de acordo com as vitórias e empates, retorna vitorias * 3 + empates"() {
		given:
		Clube clube = new Clube(
				vitorias: vitorias,
				empates: empates
		)
		expect:
		service.calculePontuacao(clube) == pontuacaoEsperada

		where:

		vitorias | empates | pontuacaoEsperada
		1        | 1       | 4
		0        | 1       | 1
		10       | 0       | 30
		10       | 0       | 30

	}

	void "Comparação de times usando a pontuação, espera o time que contenha maior pontuação, em caso de empate analisa critérios de desempate"() {
		given:
		Clube clube1 = new Clube(
				vitorias: vitorias,
				empates: empates
		)
		Clube clube2 = new Clube(
				vitorias: vitorias2,
				empates: empates2
		)
		expect:
		service.compare(clube1, clube2) == timeCampeao

		where:

		vitorias | empates | vitorias2 | empates2 | timeCampeao
		0        | 0       | 1         | 0        | -1
		1        | 0       | 0         | 0        | 1
		0        | 1       | 0         | 1        | 0
		10       | 1       | 0         | 10       | 1
		1        | 0       | 0         | 3        | 1


	}



}
