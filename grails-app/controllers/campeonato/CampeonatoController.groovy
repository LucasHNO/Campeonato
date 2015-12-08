package campeonato

import br.com.zeroglosa.treinamento.Campeonato
import br.com.zeroglosa.treinamento.Clube

class CampeonatoController {




    def index() {


    }

    void criaCampeonato(){
        Campeonato campeonato = new Campeonato(nome: "${params.nome}")
            render "Campeonato ${campeonato.nome} criado com sucesso"

    }
    void adicionaClubes(Campeonato campeonato){

        Clube time = new Clube(
                nome: params.nome,
                vitorias: params.vitorias,
                derrotas: params.derrotas,
                empates: params.empates,
                golsPro: params.golsPro,
                golsContra: params.golsContra
        )

        campeonato.adicionaClubes(time)

        render "Clube ${time.nome} adicionado ao campeonato ${campeonato.nome}"
    }
}
