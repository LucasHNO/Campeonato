package campeonato

import br.com.zeroglosa.treinamento.CalcularResultadosService
import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.CampeonatoService
import br.com.zeroglosa.treinamento.Clube
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.gmock.WithGMock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CampeonatoController)
@Mock([Campeonato,CampeonatoService,CalcularResultadosService,Clube])
@WithGMock
class CampeonatoControllerSpec extends Specification {


    void "Criação de um novo campeonato esperando o retorno de uma mensagem de sucesso"(){
        when:
        params.nomeCampeonato = "Brasileirão"
        String resultadoEsperado = "Campeonato Brasileirão adicionado com sucesso!"
        controller.criaCampeonato()
        then:
        response.text == resultadoEsperado

    }

    void "Adição de um novo time a um campeonato existe deve retornar mensagem de sucesso com nome do clube"(){
        when:
        params.id = "1"
        params.nome = "Cruzeiro"
        params.vitorias = "10"
        params.derrotas = "0"
        params.empates = "1"
        params.golsPro = "10"
        params.golsContra = "0"
        controller.adicionaClubes()

        String resultadoEsperado = "Clube Cruzeiro adicionado com sucesso ao campeonato!"
        then:
        response.text == resultadoEsperado
    }

    void "mostra o campeao do campeonato, esperado é cruzeiro"(){
        setup:
        Clube clube = new Clube(nome:"cruzeiro",vitorias: 10,derrotas: 0,empates: 0,golsPro: 10,golsContra: 0)
        params.id = "1"
        when:
        String resultadoEsperado = "O campeão é o cruzeiro"
        controller.campeonatoService = mock(CampeonatoService)
        controller.campeonatoService.obterCampeao("1").returns(clube)
        play{
            controller.exibeCampeao()
        }
        then:
        response.text == resultadoEsperado
    }

    void "mostra o lanterna do campeonato, esperado é o vasco"(){
        setup:
        Clube clube = new Clube(nome:"vasco",vitorias: 2,derrotas: 0,empates: 0,golsPro: 10,golsContra: 0)
        params.id = "1"
        when:
        String resultadoEsperado = "O lanterna é o vasco"
        controller.campeonatoService = mock(CampeonatoService)
        controller.campeonatoService.obterLanterna("1").returns(clube)
        play{
            controller.exibeLanterna()
        }
        then:
        response.text == resultadoEsperado
    }
}
