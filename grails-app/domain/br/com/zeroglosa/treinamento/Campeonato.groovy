package br.com.zeroglosa.treinamento

class Campeonato {

	String nome

	static hasMany = [clubes:Clube]

	def clubesParticipantes = []

	void adicionaClubes(Clube clube){
		clubesParticipantes+=clube
	}



	static constraints = {
	}
}
