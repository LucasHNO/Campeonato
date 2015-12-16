<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Campeonato ZG</title>
    <script type="text/javascript">

        function retornoSalvarCampeonato(data) {
            $("#divMensagemCampeonato").html(data.toString())
            $("#frmCampeonato input[name=nomeCampeonato]").val("")
            confirm(data.toString())
        }
        function retornoSalvarTime(data) {
            $("#divMensagemClube").html(data.toString())
            confirm(data.toString())
            $("#frmTimes input[name=nome]").val("")
            $("#frmTimes input[name=vitorias]").val("")
            $("#frmTimes input[name=empates]").val("")
            $("#frmTimes input[name=derrotas]").val("")
            $("#frmTimes input[name=golsPro]").val("")
            $("#frmTimes input[name=golsContra]").val("")
        }

        function retornoExibirTabela(data){
            $("#divTabela").html(data)
        }


    </script>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    .controller {
        line-height: 1.3;
        list-style-position: inside;
        margin: 1.5em 0;

    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>
<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="status" role="complementary">
    <h1>Funcionalidades</h1>
    <ul>
        <li class="controller"><g:link controller="campeonato" action="index">Home</g:link></li>
        <li class="controller"><g:remoteLink controller="campeonato" action="exibeTelaCampeonato" update="page-body">Criar Campeonato</g:remoteLink></li>
        <li class="controller"><g:remoteLink controller="campeonato" action="exibeTelaCadastroClubes" update="page-body">Adicionar Clubes</g:remoteLink></li>
        <li class="controller"><g:remoteLink controller="campeonato" action="exibeTelaCampeao" update="page-body">Exibir Campeão</g:remoteLink></li>
        <li class="controller"><g:remoteLink controller="campeonato" action="exibeTelaLanterna" update="page-body">Exibir Lanterna</g:remoteLink></li>
        <li class="controller"><g:remoteLink controller="campeonato" action="exibeTelaTabela" update="page-body">Exibir Tabela</g:remoteLink></li>


    </ul>

</div>

<div id="page-body" role="main">
    <h1>Bem vindo ao software gerenciador de campeonatos</h1>

    <p>As regras são:</p>

    <div id="controller-list" role="navigation">

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
</div>
</body>
</html>
