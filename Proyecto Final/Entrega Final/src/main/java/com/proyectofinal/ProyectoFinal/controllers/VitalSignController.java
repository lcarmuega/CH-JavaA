package com.proyectofinal.ProyectoFinal.controllers;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.responseDTO.VitalSignDTO;
import com.proyectofinal.ProyectoFinal.services.VitalSignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vitalSigns")
@Tag(name = "Signos Vitales", description = "Endpoint de signos vitales")
public class VitalSignController {
    @Autowired
    private VitalSignService vitalSignService;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping
    @Operation(summary = "Obtener signos vitales", description = "Servicio para obtener todos los signos vitales")
    @ResponseStatus(code = HttpStatus.OK)
    List<VitalSignDTO> getVitalSigns(){
        return vitalSignService.getVitalSigns();
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/patient")
    @Operation(summary = "Obtener signos vitales de un paciente", description = "Servicio para obtener los signos vitales de un paciente")
    @ResponseStatus(code = HttpStatus.OK)
    List<VitalSignDTO> getVitalSignsByPatient(@RequestBody Patient patient){
        return vitalSignService.getVitalSignsByPatient(patient);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/patient/update/{idVS}")
    @Operation(summary = "Actualizar signo vital", description = "Servicio para actualizar un signo vital")
    List<VitalSignDTO> updateVitalSigns(@RequestBody VitalSign vitalSign, @PathVariable Integer idVS){
        return vitalSignService.updateVitalSigns(vitalSign, idVS);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/patient/delete/{idVS}")
    @Operation(summary = "Eliminar signo vital", description = "Servicio para eliminar un signo vital")
    void deleteVitalSign(@PathVariable Integer idVS){
        vitalSignService.deleteVitalSign(idVS);
    }
}