<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <g:javascript library="jquery" />

    <style type="text/css">
    #principal_superior {
        width: 90%;
        border: 2px solid black;
        clear: both;
    }

    #campeonato {
        width: 90%;
        border: 2px solid black;
        clear: both;

    }

    #times {
        width: 90%;
        border: 2px solid #b2d1ff;
        clear: both;
    }

    </style>

    <title>Campeonato Zero Glosa</title>
</head>

<body>
<div id="principal_superior">

    <h3>Bem vindo ao software gerenciador de campeonatos.</h3>
    <h4>As regras são as seguintes:</h4>
    <ul>
        <li>Vitória: 3 pontos</li>
        <li>Derrota: 0 pontos</li>
        <li>Empate: 1 ponto</li>
        <li>Vence quem obtiver maior número de pontos.</li>
    </ul>
    <h4>Critérios de Desempate</h4>
    <ul>
        <li>Número de vitórias</li>
    </ul>
</div>


<div id="mensagem"></div>
<div id="times">
    <g:formRemote name="frmTimes" url="[controller: 'campeonato', action: 'criaCampeonato']" update="mensagem">
        Nome Campeonato<input type="text" name="nomeCampeonato" value=""><br>
        Nome Time<input type="text" name="nome" value=""><br>
        Vitórias<input type="text" name="vitorias" value=""><br>
        Derrotas<input type="text" name="derrotas" value=""><br>
        Empates<input type="text" name="empates" value=""><br>
        Gols Pró<input type="text" name="golsPro" value=""><br>
        Gols Contra<input type="text" name="golsContra" value=""><br>
        <input type="submit" name="btnSalvar" value="Salvar">

    </g:formRemote>
</div>
<div id="RetornaDados">
    <g:formRemote name="frmResultados" url="[controller: 'campeonato', action: 'exibeCampeao']">
      <input type="submit" name="btnSolicitar" value="Exibir Campeao">
    </g:formRemote>

</div>



</body>
</html>