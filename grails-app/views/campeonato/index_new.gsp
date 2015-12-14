<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-md-10">
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
    <div class="col-md-10">
        <table class="table table-striped">
            <thead style="text-align: center">
            <th>ID</th>
            <th>CAMPEONATO</th>
            <th>QUANTIDADE DE TIMES</th>
            <th>AÇÕES</th>
            </thead>
            <tbody>
            <g:each in="${Campeonato.all}" var="campeonato">
                <tr>
                    <td>${campeonato.id}</td>
                    <td>${campeonato.nome}</td>
                    <td>${campeonato.clubes.size()}</td>
                    <td>
                        <g:link action="obterTabela" params="[idCampeonato: campeonato.id]" class="btn btn-primary">Ver Tabela</g:link>
                        <g:link action="createtime" params="[idCampeonato: campeonato.id]" class="btn btn-primary">Adicionar time</g:link>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:link controller="campeonato" action="create" class="btn btn-primary">Novo Campeonato</g:link>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>