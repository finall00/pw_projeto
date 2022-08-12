<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="w-75 mx-auto">
    <h3 class="text-center my-3">Cadastrar atividade principal</h3>
    <form method="post" action="CadastrarAtividadePrincipal">
        <div class="row my-3">
            <div class="form-group col-6">
                <label for="codigoAtividadePrincipal">Código:</label>
                <input type="text" class="form-control" id="codigoAtividadePrincipal" name="codigoAtividadePrincipal" readonly value="${atividadePrincipal.codigoAtividadePrincipal > 0 ? atividadePrincipal.codigoAtividadePrincipal : ""}"/>
            </div>
            <div class="form-group col-6">
                <label for="descricaoAtividadePrincipal">Descrição:</label>
                <input type="text" class="form-control" id="descricaoAtividadePrincipal" name="descricaoAtividadePrincipal" placeholder="Descrição" required value="${atividadePrincipal.descricaoAtividadePrincipal}"/>
            </div>
        </div>
        <div class="row my-3">
            <div class="form-group col-12 text-center">
                <button class="btn btn-success" type="submit">Cadastrar</button>
                <a href="ListarAtividadePrincipal" class="btn btn-secondary">Voltar</a>
            </div>
        </div>
    </form>
</div>
<jsp:include page="/rodape.jsp"/>