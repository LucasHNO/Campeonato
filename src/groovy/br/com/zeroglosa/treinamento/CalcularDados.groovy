package br.com.zeroglosa.treinamento


interface CalcularDados extends Comparator<Clube> {

	Clube retorneCampeao(String idCampeonato)

	Clube retorneUltimoColocado(String idCampeonato)

	List<Clube> ordenaListaClubes(Campeonato campeonato)
}