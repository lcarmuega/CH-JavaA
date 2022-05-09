package com.proyectofinal.ProyectoFinal.controllers;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.responseDTO.PatientDTO;
import com.proyectofinal.ProyectoFinal.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Pacientes", description = "Endpoint de pacientes")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping
    @Operation(summary = "Lista de los pacientes", description = "Servicio para obtener los pacientes.")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PatientDTO> getPatients(){
        return patientService.getPatients();
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/findId/{id}")
    @Operation(summary = "Dato de un paciente por ID", description = "Servicio para obtener un paciente segun su ID")
    public PatientDTO getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/findName/{nombre}")
    @Operation(summary = "Dato de un paciente por nombre", description = "Servicio para obtener un paciente segun su nombre")
    public PatientDTO getPatientByName(@PathVariable String nombre){
        return patientService.getPatientByFullName(nombre);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @PostMapping("/add")
    @Operation(summary = "Agregar un paciente", description = "Servicio para agregar un paciente a la bd")
    public PatientDTO addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
    
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/addMultiple")
    @Operation(summary = "Agregar pacientes", description = "Servicio para agregar varios pacientes a la bd")
    public List<PatientDTO> addMultiplePatients(@RequestBody List<Patient> patients){
        return patientService.addPatientList(patients);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_EMPLOYEE')")
    @GetMapping("/addVS/{id}")
    @Operation(summary = "Registrar signo vital", description = "Servicio para registrar un signo vital de un paciente, con el ID del paciente")
    public PatientDTO addVitalSign(@PathVariable Integer id, @RequestBody VitalSign vitalSign){
        return patientService.addVitalSign(id, vitalSign);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/updatePatient/{id}")
    @Operation(summary = "Actualizar datos del paciente", description = "Servicio para actualizar los datos de un paciente")
    public PatientDTO updatePatient(@PathVariable Integer id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/deletePatient/{id})")
    @Operation(summary = "Eliminar paciente", description = "Servicio para eliminar un paciente")
    public void deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/deletePatientGen/{id}")
    @Operation(summary = "Eliminar paciente - Generico", description = "Servicio para eliminar un paciente - Generico")
    public void deletePatientGen(@PathVariable Integer id){
        patientService.deleteById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/count")
    @Operation(summary = "Cantidad de pacientes", description = "Servicio para obtener la cantidad total de pacientes")
    public Long count(){
        return patientService.count();
    }
}
