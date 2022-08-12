package model;

public class Paciente extends Pessoa {

    private String numeroCartaoSusPaciente;
    private boolean statusPaciente;
    private AtividadePrincipal atividadePrincipal;

    public Paciente(String numeroCartaoSusPaciente, boolean statusPaciente, AtividadePrincipal atividadePrincipal, int codigoPessoa, String nomePessoa, String dataNascimentoPessoa, String cpfPessoa, String senhaPessoa) {
        super(codigoPessoa, nomePessoa, dataNascimentoPessoa, cpfPessoa, senhaPessoa);
        this.numeroCartaoSusPaciente = numeroCartaoSusPaciente;
        this.statusPaciente = statusPaciente;
        this.atividadePrincipal = atividadePrincipal;
    }
    
    public Paciente() {
        super(0, null, null, null, null);
    }

    public String getNumeroCartaoSusPaciente() {
        return numeroCartaoSusPaciente;
    }

    public void setNumeroCartaoSusPaciente(String numeroCartaoSusPaciente) {
        this.numeroCartaoSusPaciente = numeroCartaoSusPaciente;
    }

    public boolean isStatusPaciente() {
        return statusPaciente;
    }

    public void setStatusPaciente(boolean statusPaciente) {
        this.statusPaciente = statusPaciente;
    }

    public AtividadePrincipal getAtividadePrincipal() {
        return atividadePrincipal;
    }

    public void setAtividadePrincipal(AtividadePrincipal atividadePrincipal) {
        this.atividadePrincipal = atividadePrincipal;
    }
}