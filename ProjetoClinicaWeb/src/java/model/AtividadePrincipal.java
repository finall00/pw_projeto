package model;

public class AtividadePrincipal {

    private int codigoAtividadePrincipal;
    private String descricaoAtividadePrincipal;

    public AtividadePrincipal(int codigoAtividadePrincipal, String descricaoAtividadePrincipal) {
        this.codigoAtividadePrincipal = codigoAtividadePrincipal;
        this.descricaoAtividadePrincipal = descricaoAtividadePrincipal;
    }

    public AtividadePrincipal() {

    }

    public AtividadePrincipal(int codigoAtividadePrincipal) {
        this.codigoAtividadePrincipal = codigoAtividadePrincipal;
    }

    public int getCodigoAtividadePrincipal() {
        return codigoAtividadePrincipal;
    }

    public void setCodigoAtividadePrincipal(int codigoAtividadePrincipal) {
        this.codigoAtividadePrincipal = codigoAtividadePrincipal;
    }

    public String getDescricaoAtividadePrincipal() {
        return descricaoAtividadePrincipal;
    }

    public void setDescricaoAtividadePrincipal(String descricaoAtividadePrincipal) {
        this.descricaoAtividadePrincipal = descricaoAtividadePrincipal;
    }
}
