<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
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
        height: 20px;
        border: 2px solid #b2d1ff;
        clear: both;
        display: none;
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

<div id="campeonato">
    <g:formRemote name="frmCampeonato" url="[controller: 'campeonato', action: 'criaCampeonato']">
        <p></p>
        Nome Campeonato<input type="text" name="nome" value="">
        <input type="submit" name="btnSalvar" value="Salvar">
    </g:formRemote>
</div>

<div id="times">
    <g:formRemote name="frmTimes" url="[controller: 'campeonato', action: 'adicionaClubes']">
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