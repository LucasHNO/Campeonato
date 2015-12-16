package campeonato

import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube

class CampeonatoController {

    def calcularResultadosService
    def campeonatoService

    def index() {
        render(view: "/index")
    }
    def exibeTelaCampeonato(){
        List<Campeonato> campeonatos = Campeonato.list()
        render(template:"/campeonato/form_campeonato", model:[campeonatos: campeonatos])
    }

    def criaCampeonato() {

        if(params.nomeCampeonato!="") {
            Campeonato campeonato = campeonatoService.criaCampeonato(params.nomeCampeonato)
            render("Campeonato ${campeonato.nome} adicionado com sucesso!")
        }else{
            render("Por favor digite um nome para o Campeonato!")

        }
    }
    def exibeTelaCadastroClubes(){
        render(template:"/campeonato/form_clubes")

    }

    def adicionaClubes() {
        if(params.id!="null") {
        Clube time = campeonatoService.adicionaTimes(params.id, params.nome, params.vitorias, params.derrotas,
                params.empates, params.golsPro, params.golsContra)
        render("Clube ${time.nome} adicionado com sucesso ao campeonato!")
        }
        else{
            render("Campeonato não selecionado ou não criado!")
        }
    }

    def exibeTelaCampeao(){
        render(template: "/campeonato/form_campeao")
    }

    def exibeCampeao() {
        Clube campeao
             if(params.id!="null") {
            campeao = campeonatoService.obterCampeao(params.id)
            render("O campeão é o ${campeao.nome}")
             }
             else{
                 render("Campeonato não selecionado ou não criado!")
             }

    }
    def exibeTelaLanterna(){
        render(template: "/campeonato/form_lanterna")
    }
    def exibeLanterna(){
        Clube lanterna
            if(params.id!="null") {
            lanterna = campeonatoService.obterLanterna(params.id)
            render("O lanterna é o ${lanterna.nome}")
            }
            else{
                render("Campeonato não selecionado ou não criado!")
            }


    }
    def exibeTelaTabela(){
        render(template: "/campeonato/form_telaTabela")
    }

    def exibeTabela(){
            List<Clube> clubes
            params.id
            if(params.id!="null") {
                clubes = campeonatoService.obterTabela(params.id)
                render(template: "/campeonato/form_tabela", model: [clubes: clubes])
            }
            else{
                render("Campeonato não selecionado ou não criado!")
            }

    }


}
