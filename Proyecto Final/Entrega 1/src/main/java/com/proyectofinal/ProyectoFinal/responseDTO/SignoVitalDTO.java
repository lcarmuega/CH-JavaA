package com.proyectofinal.ProyectoFinal.responseDTO;

import com.proyectofinal.ProyectoFinal.entities.SignoVital;

public class SignoVitalDTO {
    private Integer id;
    private String signoVital;
    private Integer valor;

    public SignoVitalDTO() {
    }

    public SignoVitalDTO(SignoVital signoVital) {
        this.id = signoVital.getId();
        this.signoVital = signoVital.getSignoVital();
        this.valor = signoVital.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignoVital() {
        return signoVital;
    }

    public void setSignoVital(String signoVital) {
        this.signoVital = signoVital;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
