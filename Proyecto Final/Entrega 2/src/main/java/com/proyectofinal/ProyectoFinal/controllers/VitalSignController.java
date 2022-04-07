package com.proyectofinal.ProyectoFinal.controllers;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.responseDTO.VitalSignDTO;
import com.proyectofinal.ProyectoFinal.services.VitalSignService;
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
@RequestMapping("/api/vitalSigns")
public class VitalSignController {
    @Autowired
    private VitalSignService vitalSignService;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping
    List<VitalSignDTO> getVitalSigns(){
        return vitalSignService.getVitalSigns();
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/patient")
    List<VitalSignDTO> getVitalSignsByPatient(@RequestBody Patient patient){
        return vitalSignService.getVitalSignsByPatient(patient);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/patient/update/{idVS}")
    List<VitalSignDTO> updateVitalSigns(@RequestBody VitalSign vitalSign, @PathVariable Integer idVS){
        return vitalSignService.updateVitalSigns(vitalSign, idVS);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/patient/delete/{idVS}")
    void deleteVitalSign(@PathVariable Integer idVS){
        vitalSignService.deleteVitalSign(idVS);
    }
}