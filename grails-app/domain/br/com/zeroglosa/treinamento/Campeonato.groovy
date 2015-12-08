package br.com.zeroglosa.treinamento

class Campeonato {

	String nome

	def clubesParticipantes = []

	void adicionaClubes(Clube clube){
		clubesParticipantes+=clube
	}



	static constraints = {
	}
}
