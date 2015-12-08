

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<style type="text/css">
		#principal_superior{
			width: 90%;
			height: 20px;
			border:2px solid #b2d1ff;
		}




	</style>

	<title>Campeonato Zero Glosa</title>
</head>
<body>
<div id="principal_superior">
	<p>
		Bem vindo ao software gerenciador de campeonatos.
		As regras são as seguintes:
		-Vitória: 3 pontos
		-Derrota: 0 pontos
		-Empate: 1 ponto
		-Vence quem obtiver maior número de pontos.

		Critérios de Desempate
		-Número de vitórias
	</p>
</div>
<div id="campeonato">
	<g:formRemote name="frmCampeonato" url="[controller:'campeonato',action:'criaCampeonato']">
		Nome Campeonato<input type="text" name="nome" value="">
		<input type="submit" name="btnSalvar" value="Salvar">
	</g:formRemote>
</div>
<div id="times">
	<g:formRemote name="frmTimes" url="[controller: 'campeonato',action:'adicionaClubes']">
		Nome Time<input type="text" name="nome" value="">
		Vitórias<input type="text" name="vitorias" value="">
		Derrotas<input type="text" name="derrotas" value="">
		Empates<input type="text" name="empates" value="">
		Gols Pró<input type="text" name="golsPro" value="">
		Gols Contra<input type="text" name="golsContra" value="">
		<input type="submit" name="btnSalvar" value="Salvar">

	</g:formRemote>
</div>

</body>
</html>