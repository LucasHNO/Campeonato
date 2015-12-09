package br.com.zeroglosa.treinamento

class Clube {
    String nome
    int vitorias
    int derrotas
    int empates
    int golsPro
    int golsContra

    static belongsTo = [campeonato:Campeonato]

    int getSaldo(){
        return golsPro - golsContra
    }


    static constraints = {
    }
}
