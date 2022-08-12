<%@page import="java.util.List"%>
<%@page import="model.AtividadePrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="container-fluid">
    <table class="table text-center">
        <thead>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
                <th colspan="2">Ações</th>
            </tr>
        </thead>
        <%
            List<AtividadePrincipal> lista = (List<AtividadePrincipal>) request.getAttribute("atividadesPrincipais");
        %>
        <tbody>
            <%
                for (AtividadePrincipal atividadePrincipal : lista) {
            %>
            <tr>
                <td><%= atividadePrincipal.getCodigoAtividadePrincipal()%></td>
                <td><%= atividadePrincipal.getDescricaoAtividadePrincipal()%></td>
                <td><a href="ConsultarAtividadePrincipal?codigoAtividadePrincipal=<%= atividadePrincipal.getCodigoAtividadePrincipal()%>" class="btn btn-info">Alterar</a></td>
                <td><a href="ExcluirAtividadePrincipal?codigoAtividadePrincipal=<%= atividadePrincipal.getCodigoAtividadePrincipal()%>" class="btn btn-danger">Excluir</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <div class="row my-3">
        <div class="form-group col-12 text-center">
            <a href="NovaAtividadePrincipal" class="btn btn-primary">Nova atividade principal</a>
            <a href="index.jsp" class="btn btn-secondary">Voltar</a>
        </div>
    </div>
    <p class="text-center">${mensagem}</p>
</div>
<jsp:include page="/rodape.jsp"/>