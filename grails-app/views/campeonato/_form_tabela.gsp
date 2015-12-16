<style type="text/css">
#divTabela {
    overflow-y: auto;
    height: 300px;
}


</style>
<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<h3>Tabela Classificação</h3>
<div id="divTabela">
    <table>
        <thead>
        <th>Time</th>
        <th>Posição</th>
        <th>Vitórias</th>
        <th>Empates</th>
        <th>Derrotas</th>
        <th>Saldo de Gols</th>
        </thead>
        <g:each in="${clubes}" var="clube">
            <tr style="background-color: khaki">
                <td>${clube.nome}</td>
                <td>${clubes.indexOf(clube) + 1}</td>
                <td>${clube.vitorias}</td>
                <td>${clube.empates}</td>
                <td>${clube.derrotas}</td>
                <td>${clube.saldo}</td>
            </tr>
        </g:each>
    </table>
</div>

