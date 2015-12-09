package campeonato

import br.com.zeroglosa.treinamento.CalcularDados
import br.com.zeroglosa.treinamento.CalcularResultadosService
import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube

class CampeonatoController {

    def calcularResultadosService
    def campeonatoService

    def index() {
        render(view:"/campeonato/index")
    }

    def criaCampeonato(){
            adicionaClubes()
    }

    def adicionaClubes(){

        Campeonato campeonato = campeonatoService.criaCampeonato(params.nomeCampeonato)

        Clube time = new Clube(
                campeonato: campeonato,
                nome: params.nome,
                vitorias: params.vitorias.toInteger(),
                derrotas: params.derrotas.toInteger(),
                empates: params.empates.toInteger(),
                golsPro: params.golsPro.toInteger(),
                golsContra: params.golsContra.toInteger()
        )
        time.save(flush: true)
        campeonato.adicionaClubes(time)


        render ("Clube ${time.nome} adicionado ao campeonato ${campeonato.nome}")
    }

    def exibeCampeao(){
        Clube campeao

        if(!campeonato){
            render ("Campeonato não iniciado!")
        }

        else
        {
            campeao = calcularResultadosService.retorneCampeao(campeonato)
            render ("O campeão é o ${campeao.nome}")
        }
    }


}
