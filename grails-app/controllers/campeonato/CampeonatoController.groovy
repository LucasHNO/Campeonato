package campeonato

import br.com.zeroglosa.treinamento.CalcularDados
import br.com.zeroglosa.treinamento.CalcularResultadosService
import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube

class CampeonatoController {

    def calcularResultadosService
    def campeonatoService

    def index() {
        render(view: "/campeonato/index")
    }

    def criaCampeonato() {
        adicionaClubes()
    }

    def adicionaClubes() {
        Campeonato campeonato = campeonatoService.criaCampeonato(params.nomeCampeonato)

        Clube time = campeonatoService.adicionaTimes(campeonato, params.nome, params.vitorias, params.derrotas,
                params.empates, params.golsPro, params.golsContra)

        render("Clube ${time.nome} adicionado ao campeonato ${campeonato.nome}")
    }

    def exibeCampeao() {
        Clube campeao

        Campeonato campeonato = Campeonato.get(params.id)

        if (!campeonato) {
            render("Campeonato não iniciado!")
        } else {
            campeao = calcularResultadosService.retorneCampeao(campeonato)
            render("O campeão é o ${campeao.nome}")
        }
    }
    def exibeLanterna(){
        Clube lanterna

        Campeonato campeonato = Campeonato.get(params.id)
        if (!campeonato) {
            render("Campeonato não iniciado!")
        } else {
            lanterna = calcularResultadosService.retorneUltimoColocado(campeonato)
            render("O campeão é o ${lanterna.nome}")
        }

    }


}
