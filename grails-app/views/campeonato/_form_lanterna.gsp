<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<h3>Exibir Lanterna</h3>
<g:formRemote name="frmResultadosLanterna" url="[controller: 'campeonato', action: 'exibeLanterna']" onSuccess="retornoSalvarTime(data)">
    <g:select name="id"
              optionKey="id"
              from="${Campeonato.list()}"
              optionValue="nome"
              value="id"
              noSelection="['null': 'Selecione Campeonato']"/>
    <input type="submit" name="btnSolicitar" value="Exibir Lanterna">
</g:formRemote>