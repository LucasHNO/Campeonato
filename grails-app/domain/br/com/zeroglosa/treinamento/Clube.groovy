package br.com.zeroglosa.treinamento

class Clube {
    String nome
    int vitorias
    int derrotas
    int empates
    int golsPro
    int golsContra

    int getSaldo(){
        return golsPro - golsContra
    }

    static belongsTo = [campeonato:Campeonato]

    static constraints = {
    }
}
