<%@page import="model.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card my-5 text-center w-75 mx-auto">
    <div class="card-header">
        <h3>Pacientes</h3>
    </div>
    <div class="card-body">
        <div class="alert alert-primary" role="alert">
            ${mensagem}
        </div>
        <hr/>
        <a class="btn btn-success" href="NovoPaciente">Novo</a>
        <a class="btn btn-secondary" href="index.jsp">Voltar</a>
        <hr/>
        <% List<Paciente> lista = (List<Paciente>) request.getAttribute("pacientes"); %>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Data de nascimento</th>
                    <th>CPF</th>
                    <th>Nº Cartão SUS</th>
                    <th>Atividade principal</th>
                    <th>Status</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Paciente paciente : lista) {
                %>
                <tr>
                    <td><%= paciente.getCodigoPessoa()%></td>
                    <td><%= paciente.getNomePessoa()%></td>
                    <td><%= paciente.getDataNascimentoPessoa()%></td>
                    <td><%= paciente.getCpfPessoa()%></td>
                    <td><%= paciente.getNumeroCartaoSusPaciente()%></td>
                    <td><%= paciente.getAtividadePrincipal().getDescricaoAtividadePrincipal()%></td>
                    <td><%= paciente.isStatusPaciente() ? "Ativo" : "Inativo"%></td>
                    <td><a class="btn btn-info" href="ConsultarPaciente?codigoPaciente=<%= paciente.getCodigoPessoa()%>">Alterar</a></td>
                    <td><a class="btn btn-danger" href="ExcluirPaciente?codigoPaciente=<%= paciente.getCodigoPessoa()%>">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>