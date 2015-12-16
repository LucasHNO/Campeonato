<h3>Adicionar Novo Campeonato</h3>
<div id="divMensagemCampeonato"></div>
<g:formRemote id="frmCampeonato" name="frmCampeonato" url="[controller: 'campeonato', action: 'criaCampeonato']" onSuccess="retornoSalvarCampeonato(data)">
    Nome Campeonato: <input type="text" name="nomeCampeonato" value="">
    <input type="submit" name="btnSalvar" value="Salvar">
</g:formRemote>