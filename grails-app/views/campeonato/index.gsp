<%@ page import="br.com.zeroglosa.treinamento.Campeonato" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Campeonato Zero Glosa</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <g:javascript library="jquery"/>
    <script type="text/javascript">

        function retornoSalvarCampeonato(data){
                $("#divMensagemCampeonato").html(data.toString())
                $("#frmCampeonato input[name=nomeCampeonato]").val("")
                confirm(data.toString())
                parent.window.document.location.href = '';
        }

        function retornoSalvarTime(data){
                $("#divMensagemClube").html(data.toString())
                confirm(data.toString())
                $("#frmTimes input[name=nome]").val("")
                $("#frmTimes input[name=vitorias]").val("")
                $("#frmTimes input[name=empates]").val("")
                $("#frmTimes input[name=derrotas]").val("")
                $("#frmTimes input[name=golsPro]").val("")
                $("#frmTimes input[name=golsContra]").val("")
                parent.window.document.location.href = '';
        }

    </script>

    <style type="text/css">
    #principal_superior {
        width: 90%;
        padding:6px 4px;
        border: 2px solid black;
        clear: both;
    }
    #campeonatos{
        width: 45%;
        padding:6px 4px;
        border: 2px solid black;
        clear: both;
        left: auto;
    }

    #times {
        width: 45%;
        padding:6px 4px;
        border: 2px solid black;
        clear: both;
        left: auto;
    }
    #RetornaDadosCampeao{
        display:inline-block;
        width: 22.5%;
        border: 2px solid black;
        clear: both;
        left: auto;
    }
    #RetornaDadosLanterna{
        display:inline-block;
        width: 22.5%;
        border: 2px solid black;
        clear: both;
        left: auto;
    }

    </style>

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
<div id="campeonatos">
    <h3>Adicionar Novo Campeonato</h3>
    <div id="divMensagemCampeonato"></div>
    <g:formRemote id="frmCampeonato" name="frmCampeonato" url="[controller: 'campeonato', action: 'criaCampeonato']"  onSuccess="retornoSalvarCampeonato(data)">
    Nome Campeonato: <input type="text" name="nomeCampeonato" value="" >
    <input type="submit" name="btnSalvar" value="Salvar">
    </g:formRemote>
</div>


<div id="times">
    <h3>Adicionar Times ao Campeonato</h3>
    <div id="divMensagemClube"></div>
    <g:formRemote name="frmTimes" url="[controller: 'campeonato', action: 'adicionaClubes']" update="mensagem"  onSuccess="retornoSalvarTime(data)">
        Nome Campeonato: <g:select name="id"
                  optionKey="id"
                  from="${Campeonato.list()}"
                  optionValue="nome"
                  value="id"
                  noSelection="['null': 'Selecione Campeonato']"/><br>
        <label> Nome Time: <input type="text" name="nome" value="" ><br>
        <label> Vitórias:  <input type="text" name="vitorias" value="" ><br>
        <label> Derrotas: <input type="text" name="derrotas" value=""><br>
        <label> Empates: <input type="text" name="empates" value=""><br>
        <label> Gols Pró: <input type="text" name="golsPro" value=""><br>
        <label> Gols Contra: <input type="text" name="golsContra" value=""><br>
        <label><input type="submit" name="btnSalvar" value="Salvar">

    </g:formRemote>
</div>

<div id="RetornaDadosCampeao">
    <h3>Exibir Campeão</h3>
    <g:formRemote  name="frmResultadosCampeao" url="[controller: 'campeonato', action: 'exibeCampeao']" onSuccess="retornoSalvarTime(data)">
        <g:select name="id"
                  optionKey="id"
                  from="${Campeonato.list()}"
                  optionValue="nome"
                  value="id"
                  noSelection="['null': 'Selecione Campeonato']"/>
        <input type="submit" name="btnSolicitar" value="Exibir Campeao">
    </g:formRemote>
</div>
<div id="RetornaDadosLanterna">
    <h3>Exibir Lanterna</h3>
    <g:formRemote name="frmResultadosLanterna" url="[controller: 'campeonato', action: 'exibeLanterna']">
        <g:select name="id"
                  optionKey="id"
                  from="${Campeonato.list()}"
                  optionValue="nome"
                  value="id"
                  noSelection="['null': 'Selecione Campeonato']"/>
        <input type="submit" name="btnSolicitar" value="Exibir Lanterna">
    </g:formRemote>
</div>


</body>
</html>