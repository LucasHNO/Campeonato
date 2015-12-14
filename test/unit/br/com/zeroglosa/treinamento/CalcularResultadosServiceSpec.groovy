package br.com.zeroglosa.treinamento

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.gmock.WithGMock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CalcularResultadosService)
@Mock([Campeonato, CampeonatoService, CalcularResultadosService, Clube])
@WithGMock
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

    void "Ordenação de uma lista de times considerando a pontuação e os critérios de desempate,deverá retornar a lista ordenada de times"() {
        given:

        List<Clube> clubes = null

        Clube clube1 = new Clube(
                nome: nome,
                vitorias: vitorias,
                empates: empates
        )
        Clube clube2 = new Clube(
                nome: nome2,
                vitorias: vitorias2,
                empates: empates2
        )
        Campeonato campeonato = mock(Campeonato) {
            getClubes().returns([clube1, clube2])
        }
        play {
            clubes = service.ordenaListaClubes(campeonato)
        }

        expect:
        clubes*.nome == lista

        where:
        nome       | vitorias | empates | nome2         | vitorias2 | empates2 | lista
        "cruzeiro" | 0        | 0       | "corinthians" | 1         | 0        | ["corinthians", "cruzeiro"]
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 0        | ["cruzeiro", "corinthians"]
        "cruzeiro" | 10       | 1       | "corinthians" | 0         | 10       | ["cruzeiro", "corinthians"]
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 3        | ["cruzeiro", "corinthians"]

    }

    void "Busca em uma lista ordena o campeão do campeonato"() {
        given:
        Clube campeao
        List<Clube> clubes = null

        Clube clube1 = new Clube(
                nome: nome,
                vitorias: vitorias,
                empates: empates
        )
        Clube clube2 = new Clube(
                nome: nome2,
                vitorias: vitorias2,
                empates: empates2
        )
        Campeonato campeonato = mock(Campeonato) {
            getClubes().returns([clube1, clube2])
        }
        play {
            campeao = service.retorneCampeao(campeonato)
        }
        expect:
        campeao.nome == vencedor
        where:
        nome       | vitorias | empates | nome2         | vitorias2 | empates2 | vencedor
        "cruzeiro" | 0        | 0       | "corinthians" | 1         | 0        | "corinthians"
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 0        | "cruzeiro"
        "cruzeiro" | 10       | 1       | "corinthians" | 0         | 10       | "cruzeiro"
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 3        | "cruzeiro"
    }

    void "Busca em uma lista ordena o lanterna do campeonato"() {
        given:
        Clube lanterna
        List<Clube> clubes = null

        Clube clube1 = new Clube(
                nome: nome,
                vitorias: vitorias,
                empates: empates
        )
        Clube clube2 = new Clube(
                nome: nome2,
                vitorias: vitorias2,
                empates: empates2
        )
        Campeonato campeonato = mock(Campeonato) {
            getClubes().returns([clube1, clube2])
        }
        play {
            lanterna = service.retorneUltimoColocado(campeonato)
        }
        expect:
        lanterna.nome == ultimo
        where:
        nome       | vitorias | empates | nome2         | vitorias2 | empates2 | ultimo
        "cruzeiro" | 0        | 0       | "corinthians" | 1         | 0        | "cruzeiro"
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 0        | "corinthians"
        "cruzeiro" | 10       | 1       | "corinthians" | 0         | 10       | "corinthians"
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 3        | "corinthians"
    }

    void "Exite tabela atualizada com ordenão dos clubes por pontuação e calcula casos de desempate"() {
        given:

        List<Clube> clubes = null

        Clube clube1 = new Clube(
                nome: nome,
                vitorias: vitorias,
                empates: empates
        )
        Clube clube2 = new Clube(
                nome: nome2,
                vitorias: vitorias2,
                empates: empates2
        )
        Clube clube3 = new Clube(
                nome: nome3,
                vitorias: vitorias3,
                empates: empates3
        )
        Campeonato campeonato = mock(Campeonato) {
            getClubes().returns([clube1, clube2, clube3])
        }
        play {
            clubes = service.retorneTabela(campeonato)
        }

        expect:
        clubes*.nome == lista

        where:
        nome       | vitorias | empates | nome2         | vitorias2 | empates2 | nome3   | vitorias3 | empates3 | lista
        "cruzeiro" | 0        | 0       | "corinthians" | 1         | 0        | "vasco" | 0         | 1        | ["corinthians", "vasco", "cruzeiro"]
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 0        | "vasco" | 0         | 1        | ["cruzeiro", "vasco", "corinthians"]
        "cruzeiro" | 10       | 1       | "corinthians" | 0         | 10       | "vasco" | 3         | 1        | ["cruzeiro", "vasco", "corinthians"]
        "cruzeiro" | 1        | 0       | "corinthians" | 0         | 3        | "vasco" | 3         | 0        | ["vasco", "cruzeiro", "corinthians"]


    }


}
