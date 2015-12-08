package campeonato

import br.com.zeroglosa.treinamento.Campeonato
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CampeonatoController)
class CampeonatoControllerSpec extends Specification {

    void "Verifica funcao cria campeonato, apos criado renderiza criado com sucesso na view"() {
        when:
        params.nome = "Brasileirao"
        controller.criaCampeonato()

        then:
        response.text == "Campeonato Brasileirao criado com sucesso"

    }

    void "Verifica adição de clubes, retorna que o time foi adicionado com sucesso"(){
        when:
        Campeonato campeonato = new Campeonato(nome:"Brasileirão")
        params.nome = "Cruzeiro"
        params.vitorias = 3
        params.derrotas = 3
        params.empates = 4
        params.golsPro = 10
        params.golsContra = 0
        controller.adicionaClubes(campeonato)

        then:
        response.text == "Clube Cruzeiro adicionado ao campeonato Brasileirão"

    }
}
