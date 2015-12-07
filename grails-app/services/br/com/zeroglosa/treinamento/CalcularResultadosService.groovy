package br.com.zeroglosa.treinamento

import grails.transaction.Transactional

@Transactional
class CalcularResultadosService implements CalcularDados{

    @Override
    Clube retorneCampeao(Campeonato campeonato) {
        return null
    }

    @Override
    Clube retorneUltimoColocado(Campeonato campeonato) {
        return null
    }

    int calculePontuacao(Clube clube) {
        return clube.vitorias * 3 + clube.empates

    }

    @Override
    List<Clube> ordenaListaClubes(Campeonato campeonato) {
        return null
    }


    int compareEmpate(Clube clube1, Clube clube2) {
        int vitoriasClube1 = clube1.vitorias
        int vitoriasClube2 = clube2.vitorias

        return vitoriasClube1 <=> vitoriasClube2
    }

    @Override
    int compare(Clube clube1, Clube clube2) {
        int pontuacaoClube1 = calculePontuacao(clube1)
        int pontuacaoClube2 = calculePontuacao(clube2)

        int compareTimes = pontuacaoClube1 <=> pontuacaoClube2

        if(compareTimes==0){
            compareTimes = compareEmpate(clube1,clube2)
        }
        return compareTimes
    }
}
