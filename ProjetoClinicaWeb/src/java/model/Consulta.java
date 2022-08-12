package model;

public class Consulta {

    private int codigoConsulta;
    private String dataConsulta;
    private String horarioConsulta;
    private String situacaoConsulta;
    private String observacoesConsulta;
    private Paciente paciente;
    private Medico medico;

    public Consulta(int codigoConsulta, String dataConsulta, String horarioConsulta, String situacaoConsulta, String observacoesConsulta, Paciente paciente, Medico medico) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.situacaoConsulta = situacaoConsulta;
        this.observacoesConsulta = observacoesConsulta;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getSituacaoConsulta() {
        return situacaoConsulta;
    }

    public void setSituacaoConsulta(String situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public String getObservacoesConsulta() {
        return observacoesConsulta;
    }

    public void setObservacoesConsulta(String observacoesConsulta) {
        this.observacoesConsulta = observacoesConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}