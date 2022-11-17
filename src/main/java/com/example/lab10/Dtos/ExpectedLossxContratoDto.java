package com.example.lab10.Dtos;

public class ExpectedLossxContratoDto {

    private int nro_contrato;
    private float expectedLoss;

    private String nro_documento;

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getNro_contrato() {
        return nro_contrato;
    }

    public void setNro_contrato(int nro_contrato) {
        this.nro_contrato = nro_contrato;
    }

    public float getExpectedLoss() {
        return expectedLoss;
    }

    public void setExpectedLoss(float expectedLoss) {
        this.expectedLoss = expectedLoss;
    }
}
