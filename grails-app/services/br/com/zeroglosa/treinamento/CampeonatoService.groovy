package br.com.zeroglosa.treinamento

import grails.transaction.Transactional

@Transactional
class CampeonatoService {

    Campeonato criaCampeonato(String nome) {

        Campeonato campeonato = Campeonato.findByNome(nome)

        if (!campeonato) {
            campeonato = new Campeonato(nome: nome)
        }
        campeonato.validate()
        if (!campeonato.hasErrors()) {
            campeonato.save(flush: true)

        }
        return campeonato
    }
    Clube adicionaTimes(Campeonato campeonato,String nome, String vitorias,String derrotas, String empates,
                        String golsPro,String golsContra){

        Clube time = new Clube(
                campeonato: campeonato,
                nome:nome,
                vitorias: vitorias.toInteger(),
                derrotas: derrotas.toInteger(),
                empates: empates.toInteger(),
                golsPro: golsPro.toInteger(),
                golsContra: golsContra.toInteger()
        )
        time.save(flush: true)


        return time

    }






}
