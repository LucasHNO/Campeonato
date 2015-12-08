package br.com.zeroglosa.treinamento

class Campeonato {

	String nome

	List <Clube> clubesParticipantes = []

	void adicionaClubes(Clube clube){
		clubesParticipantes+=clube
	}



	static constraints = {
	}
}
