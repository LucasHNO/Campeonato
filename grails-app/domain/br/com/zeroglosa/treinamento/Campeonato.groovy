package br.com.zeroglosa.treinamento

class Campeonato {

	String nome

	List <Clube> clubesParticipantes = []

	void adicionaClubes(Clube clube){
		clubesParticipantes+=clube
	}

	static hasMany = [clubes:Clube]


	static constraints = {
	}
}
