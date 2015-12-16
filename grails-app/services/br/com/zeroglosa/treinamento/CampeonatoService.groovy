package br.com.zeroglosa.treinamento

import grails.transaction.Transactional

@Transactional
class CampeonatoService {
    def calcularResultadosService

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
    Clube adicionaTimes(String idCampeonato,String nome, String vitorias,String derrotas, String empates,
                        String golsPro,String golsContra){

        Campeonato campeonato =  Campeonato.get(idCampeonato)

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
    Clube obterCampeao(String idCampeonato){
        Clube campeao
        Campeonato campeonato = Campeonato.get(idCampeonato)
        campeao = calcularResultadosService.retorneCampeao(campeonato)

    }

    Clube obterLanterna(String idCampeonato){
        Clube lanterna
        Campeonato campeonato = Campeonato.get(idCampeonato)
        lanterna = calcularResultadosService.retorneUltimoColocado(campeonato)

    }

    List<Clube> obterTabela(String idCampeonato){
        List<Clube> clubes
        Campeonato campeonato = Campeonato.get(idCampeonato)
        clubes = calcularResultadosService.retorneTabela(campeonato)
        clubes
    }




}
