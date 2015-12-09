package campeonato

import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube

class CampeonatoController {
    def index() {
        render(view:"/campeonato/index")
    }

    def criaCampeonato(){
        adicionaClubes()
    }

    def adicionaClubes(){

        Campeonato campeonato = new Campeonato(nome: params.nomeCampeonato)
        campeonato.save(flush: true)


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




        render ("Clube ${time.nome} adicionado ao campeonato")
    }
}
