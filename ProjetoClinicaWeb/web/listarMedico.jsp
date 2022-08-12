<%@page import="model.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card my-5 text-center w-75 mx-auto">
    <div class="card-header">
        <h3>Medico</h3>
    </div>
    <div class="card-body">
        <div class="alert alert-primary" role="alert">
            ${mensagem}
        </div>
        <hr/>
        <a class="btn btn-success" href="NovoMedico">Novo</a>
        <a class="btn btn-secondary" href="index.jsp">Voltar</a>
        <hr/>
        <% List<Medico> lista = (List<Medico>) request.getAttribute("medico"); %>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Data de nascimento</th>
                    <th>CPF</th>
                    <th>CRM</th>
                    <th>Status</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Medico medico : lista) {
                %>
                <tr>
                    <td><%= medico.getCodigoPessoa()%></td>
                    <td><%= medico.getNomePessoa()%></td>
                    <td><%= medico.getDataNascimentoPessoa()%></td>
                    <td><%= medico.getCpfPessoa()%></td>
                    <td><%= medico.getCrmMedico()%></td>
                    <td><%= medico.isStatusMedico() ? "Ativo" : "Inativo"%></td>
                    <td><a class="btn btn-info" href="ConsultarMedico?codigoMedico=<%= medico.getCodigoPessoa()%>">Alterar</a></td>
                    <td><a class="btn btn-danger" href="ExcluirMedico?codigoMedico=<%= medico.getCodigoPessoa()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>