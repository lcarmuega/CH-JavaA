package com.proyectofinal.ProyectoFinal.controllers;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import com.proyectofinal.ProyectoFinal.entities.SignoVital;
import com.proyectofinal.ProyectoFinal.responseDTO.PacienteDTO;
import com.proyectofinal.ProyectoFinal.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping
    List<PacienteDTO> getPacientes(){
        return pacienteService.getPacientes();
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/findId/{id}")
    PacienteDTO getPacienteById(@PathVariable Integer id){
        return pacienteService.getPacienteById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/findName/{nombre}")
    PacienteDTO getPacienteByName(@PathVariable String nombre){
        return pacienteService.getPacienteByFullName(nombre);
    }

    @PreAuthorize("hasAuthority(SCOPE_ROLE_USER)")
    @GetMapping("/add")
    PacienteDTO addPaciente(@RequestBody Paciente paciente){
        return pacienteService.addPaciente(paciente);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/addSV/{id}")
    PacienteDTO addSignoVital(@PathVariable Integer id, @RequestBody SignoVital signoVital){
        return pacienteService.addSignoVital(id, signoVital);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/updatePaciente/{id}")
    PacienteDTO updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
        return pacienteService.updatePaciente(id, paciente);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/deletePaciente/{id})")
    void deletePaciente(@PathVariable Integer id){
        pacienteService.deletePaciente(id);
    }
}
