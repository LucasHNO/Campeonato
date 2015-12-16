<%@ page import="br.com.zeroglosa.treinamento.Campeonato" %>
<h3>Exibir Campeão</h3>
<g:formRemote name="frmResultadosCampeao" url="[controller: 'campeonato', action: 'exibeCampeao']" onSuccess="retornoSalvarTime(data)">
    <g:select name="id"
              optionKey="id"
              from="${Campeonato.list()}"
              optionValue="nome"
              value="id"
              noSelection="['null': 'Selecione Campeonato']"/>
    <input type="submit" name="btnSolicitar" value="Exibir Campeao">
</g:formRemote>

