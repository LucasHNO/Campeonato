package br.com.zeroglosa.treinamento


interface CalcularDados extends Comparator<Clube> {

	Clube retorneCampeao(Campeonato campeonato)

	Clube retorneUltimoColocado(Campeonato campeonato)

	List<Clube> ordenaListaClubes(Campeonato campeonato)





}