package br.com.zeroglosa.treinamento

import grails.transaction.Transactional

@Transactional
class CampeonatoService {

	Campeonato criaCampeonato(String nome){
		Campeonato campeonato = new Campeonato(nome: nome)
		campeonato.validate()
		if(!campeonato.hasErrors()){
			campeonato.save(flush:true)
		}

		return campeonato
	}
}
