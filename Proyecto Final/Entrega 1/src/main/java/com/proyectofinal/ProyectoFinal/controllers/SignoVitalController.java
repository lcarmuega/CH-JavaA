package com.proyectofinal.ProyectoFinal.controllers;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import com.proyectofinal.ProyectoFinal.entities.SignoVital;
import com.proyectofinal.ProyectoFinal.responseDTO.SignoVitalDTO;
import com.proyectofinal.ProyectoFinal.services.SignoVitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/signosVitales")
public class SignoVitalController {
    @Autowired
    private SignoVitalService signoVitalService;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping
    List<SignoVitalDTO> getSignosVitales(){
        return signoVitalService.getSignosVitales();
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/paciente")
    List<SignoVitalDTO> getSignosVitalesByPaciente(@RequestBody Paciente paciente){
        return signoVitalService.getSignosVitalesByPaciente(paciente);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/paciente/update/{idSV}")
    List<SignoVitalDTO> updateSignosVitales(@RequestBody SignoVital signoVital, @PathVariable Integer id){
        return signoVitalService.updateSignosVitales(signoVital, id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/paciente/delete/{idSV}")
    void deleteSignoVital(@PathVariable Integer id){
        signoVitalService.deleteSignoVital(id);
    }
}