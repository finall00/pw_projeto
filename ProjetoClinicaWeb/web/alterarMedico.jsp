<%@page import="model.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h3>Alterar Medico</h3>
    </div>
    <div class="card-body">
        
        <form action="CadastrarMedico" method="post">
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="codigoPessoa">Código:</label>
                    <input class="form-control" type="text" id="codigoPessoa" name="codigoPessoa" readonly value="${medico.codigoPessoa > 0 ? medico.codigoPessoa : ""}"/>
                </div>
                <div class="form-group col-6">
                    <label for="nomePessoa">Nome:</label>
                    <input class="form-control" type="text" id="nomePessoa" name="nomePessoa" placeholder="Nome" required value="${medico.nomePessoa}"/>
                </div>
            </div>
                
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="dataNascimentoPessoa">Data de nascimento:</label>
                    <input class="form-control" type="date" id="dataNascimentoPessoa" name="dataNascimentoPessoa" required value="${medico.dataNascimentoPessoa}"/>
                </div>
                <div class="form-group col-6">
                    <label for="cpfPessoa">CPF:</label>
                    <input data-mask="000.000.000-00" class="form-control" type="text" id="cpfPessoa" name="cpfPessoa" placeholder="CPF sem pontos e sem traços" required value="${medico.cpfPessoa}"/>
                </div>
            </div>
                
            <div class="row w-75 mx-auto">
                <div class="form-group col-6">
                    <label for="crmMedico">CRM:</label>
                    <input class="form-control" type="text" id="crmMedico" name="crmMedico" placeholder="Número da CRM " required value="${medico.crmMedico}"/>
                </div>
                <div class="form-group col-6">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="ativo" name="statusMedico" value="Ativo" ${medico.statusMedico ? "checked" : ""}/>
                        <label class="form-check-label" for="ativo">Ativo</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="inativo" name="statusMedico" value="Inativo" ${!medico.statusMedico ? "checked" : ""}/>
                        <label class="form-check-label" for="inativo">Inativo</label>
                    </div>
                </div>
            </div>
                        
            
            <div class="row mt-3">
                <div class="form-group col-12 text-center">
                    <button class="btn btn-success" type="submit">Gravar</button>
                    <a class="btn btn-secondary" href="ListarMedico">Voltar</a>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/rodape.jsp"/>