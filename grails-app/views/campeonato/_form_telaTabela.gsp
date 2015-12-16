<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<h3>Exibir Tabela</h3>
<g:formRemote name="frmResultadosCampeao" url="[controller: 'campeonato', action: 'exibeTabela']" onSuccess="retornoExibirTabela(data)">
    <g:select name="id"
              optionKey="id"
              from="${Campeonato.list()}"
              optionValue="nome"
              value="id"
              noSelection="['null': 'Selecione Campeonato']"/>
    <input type="submit" name="btnSolicitar" value="Exibir Tabela">
</g:formRemote>
<div id="divTabela"></div>