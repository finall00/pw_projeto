<%@page import="model.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="model.AtividadePrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h3>Cadastrar paciente</h3>
    </div>
    <div class="card-body">
        <form action="CadastrarPaciente" method="post">
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="codigoPessoa">Código:</label>
                    <input class="form-control" type="text" id="codigoPessoa" name="codigoPessoa" readonly value="${paciente.codigoPessoa > 0 ? paciente.codigoPessoa : ""}"/>
                </div>
                <div class="form-group col-6">
                    <label for="nomePessoa">Nome:</label>
                    <input class="form-control" type="text" id="nomePessoa" name="nomePessoa" placeholder="Nome" required value="${paciente.nomePessoa}"/>
                </div>
            </div>
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="dataNascimentoPessoa">Data de nascimento:</label>
                    <input class="form-control" type="date" id="dataNascimentoPessoa" name="dataNascimentoPessoa" required value="${paciente.dataNascimentoPessoa}"/>
                </div>
                <div class="form-group col-6">
                    <label for="cpfPessoa">CPF:</label>
                    <input data-mask="000.000.000-00" class="form-control" type="text" id="cpfPessoa" name="cpfPessoa" placeholder="CPF sem pontos e sem traços" required value="${paciente.cpfPessoa}"/>
                </div>
            </div>
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="numeroCartaoSusPaciente">Nº do cartão do SUS:</label>
                    <input class="form-control" type="text" id="numeroCartaoSusPaciente" name="numeroCartaoSusPaciente" placeholder="Número do cartão do SUS" required value="${paciente.numeroCartaoSusPaciente}"/>
                </div>
                <div class="form-group col-6">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="ativo" name="statusPaciente" value="Ativo" ${paciente.statusPaciente ? "checked" : ""}/>
                        <label class="form-check-label" for="ativo">Ativo</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="inativo" name="statusPaciente" value="Inativo" ${!paciente.statusPaciente ? "checked" : ""}/>
                        <label class="form-check-label" for="inativo">Inativo</label>
                    </div>
                </div>
            </div>
            <div class="row w-75 mx-auto">
                <div class="form-group col-12">
                    <label for="codigoAtividadePrincipal">Atividade principal:</label>
                    <% List<AtividadePrincipal> lista = (List<AtividadePrincipal>) 
                            request.getAttribute("atividadesPrincipais");
                    
                    Paciente paciente = (Paciente) request.getAttribute("paciente");
                    %>
                    <select id="codigoAtividadePrincipal" 
                            name="codigoAtividadePrincipal" class="form-control" required>
                        <option value="">Selecione...</option>
                        <%
                            for (AtividadePrincipal atividadePrincipal : lista) {
                        %>
                        <option value="<%= atividadePrincipal.getCodigoAtividadePrincipal()%>" 
                                <%= paciente.getAtividadePrincipal().getCodigoAtividadePrincipal() == 
                                        atividadePrincipal.getCodigoAtividadePrincipal() ? "selected" : "" %> >
                            <%= atividadePrincipal.getDescricaoAtividadePrincipal() %>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="form-group col-12 text-center">
                    <button class="btn btn-success" type="submit">Gravar</button>
                    <a class="btn btn-secondary" href="ListarPaciente">Voltar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>