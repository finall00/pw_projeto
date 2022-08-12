<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card">
    
    <div class="card-header text-center">
        <h3>Menu principal</h3>
    </div>
    
    <div class="card-body text-center">
        <a href="ListarPaciente" class="btn btn-primary">Pacientes</a>
        <a href="ListarMedico" class="btn btn-info">Médicos</a>
        <a href="ListarConsulta" class="btn btn-danger">Consultas</a>
        <a href="ListarAtividadePrincipal" class="btn btn-dark">Atividades principais</a>
    </div>
    
</div>
<jsp:include page="/rodape.jsp"/>