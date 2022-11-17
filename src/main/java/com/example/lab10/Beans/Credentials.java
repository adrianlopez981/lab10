package com.example.lab10.Beans;

public class Credentials {
    private String numeroDocumento;
    private int tipoUsuario;


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }
}
