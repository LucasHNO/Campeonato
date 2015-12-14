package campeonato

import br.com.zeroglosa.treinamento.CalcularDados
import br.com.zeroglosa.treinamento.CalcularResultadosService
import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube
import grails.converters.JSON;

class CampeonatoController {

    def calcularResultadosService
    def campeonatoService

    def index() {
        render(view: "/campeonato/index")
    }

    def criaCampeonato() {
        Campeonato campeonato = campeonatoService.criaCampeonato(params.nomeCampeonato)
        render("Campeonato ${campeonato.nome} adicionado com sucesso!")
    }

    def adicionaClubes() {

        Clube time = campeonatoService.adicionaTimes(params.id, params.nome, params.vitorias, params.derrotas,
                params.empates, params.golsPro, params.golsContra)
        render("Clube ${time.nome} adicionado com sucesso ao campeonato!")
    }

    def exibeCampeao() {
        Clube campeao
            campeao = campeonatoService.obterCampeao(params.id)
            render("O campeão é o ${campeao.nome}")

    }
    def exibeLanterna(){
        Clube lanterna

            lanterna = campeonatoService.obterLanterna(params.id)
            render("O lanterna é o ${lanterna.nome}")


    }

    def exibeTabela(){
            //List<Clube> clubes
            //clubes = campeonatoService.obterTabela(params.id)
            //render(view:"/campeonato/tabela")

    }


}
