package br.com.zupperacademy.ranyell.casadocodigo.controllersExceptions;

public class ValidationError {

    private String campo;
    private String erro;

    public ValidationError(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }
    public String getErro() {
        return erro;
    }

}
