<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<h3>Adicionar Times ao Campeonato</h3>

<div id="divMensagemClube"></div>
<g:formRemote name="frmTimes" url="[controller: 'campeonato', action: 'adicionaClubes']" update="divMensagemClube" onSuccess="retornoSalvarTime(data)">
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
