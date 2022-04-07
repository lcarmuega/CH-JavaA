package com.proyectofinal.ProyectoFinal;

import com.proyectofinal.ProyectoFinal.controllers.PatientController;
import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.responseDTO.PatientDTO;
import com.proyectofinal.ProyectoFinal.services.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;

    @Mock
    PatientService patientService;

    @Test
    void testGetPatients(){
        patientController.getPatients();

        verify(patientService, times(1)).getPatients();
    }

    @Test
    void testAddPatient(){
        Patient patient = new Patient();

        Mockito.when(patientService.addPatient(patient)).thenReturn(new PatientDTO());
        patientController.addPatient(patient);

        verify(patientService, times(1)).addPatient(patient);
    }

    @Test
    void testCount(){
        Mockito.when(patientService.count()).thenReturn(2L);
        patientController.count();

        verify(patientService, times(1)).count();
    }

}
