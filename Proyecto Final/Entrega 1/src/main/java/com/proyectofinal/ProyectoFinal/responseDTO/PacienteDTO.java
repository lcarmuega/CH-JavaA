package com.proyectofinal.ProyectoFinal.responseDTO;

import com.proyectofinal.ProyectoFinal.entities.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDTO {
    private Integer id;
    private String fullName;
    private Date birthDate;
    private List<SignoVitalDTO> signosVitalesDTO;

    public PacienteDTO() {
    }

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.fullName = paciente.getFullName();
        this.birthDate = paciente.getBirthDate();
        this.signosVitalesDTO = new ArrayList<>();
        paciente.getSignosVitales().forEach(sv -> this.signosVitalesDTO.add(new SignoVitalDTO(sv)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<SignoVitalDTO> getSignosVitalesDTO() {
        return signosVitalesDTO;
    }

    public void setSignosVitalesDTO(List<SignoVitalDTO> signosVitalesDTO) {
        this.signosVitalesDTO = signosVitalesDTO;
    }
}
