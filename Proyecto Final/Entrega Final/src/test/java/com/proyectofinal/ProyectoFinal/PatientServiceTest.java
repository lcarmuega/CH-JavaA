package com.proyectofinal.ProyectoFinal;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.repositories.PatientRepository;
import com.proyectofinal.ProyectoFinal.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @Mock
    PatientRepository patientRepository;

    private PatientService patientService;

    @BeforeEach
    void config(){
        patientService = new PatientService(patientRepository);
    }

    @Test
    void testGetPatient(){
        patientService.getPatients();

        verify(patientService, times(1)).getPatients();
    }

    @Test
    void testAddPatient(){
        Patient patient = new Patient();
        List<VitalSign> vitalSigns = Arrays.asList(new VitalSign(), new VitalSign());
        patient.setVitalSigns(vitalSigns);

        when(patientRepository.save(patient)).thenReturn(patient);
        patientService.addPatient(patient);

        verify(patientService, times(1)).addPatient(patient);
    }
}
