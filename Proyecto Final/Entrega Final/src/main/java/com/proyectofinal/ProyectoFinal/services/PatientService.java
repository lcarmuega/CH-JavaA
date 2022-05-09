package com.proyectofinal.ProyectoFinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.generic.GenService;
import com.proyectofinal.ProyectoFinal.repositories.PatientRepository;
import com.proyectofinal.ProyectoFinal.responseDTO.PatientDTO;

@Service
public class PatientService extends GenService<Patient, Integer> {
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        super(patientRepository);
    }

    public List<PatientDTO> getPatients(){
        return genRepository.findAll()
                .stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Integer id){
        Patient foundPatient = genRepository.findById(id).orElse(null);
        if(foundPatient != null)
            return new PatientDTO(foundPatient);
        return null;
    }

    public PatientDTO getPatientByFullName(String fullName){
        Patient foundPatient = ((PatientRepository) genRepository).findByFullName(fullName);
        if(foundPatient != null)
            return new PatientDTO(foundPatient);
        return null;
    }

    @Transactional
    public PatientDTO addPatient(Patient newPatient){
        newPatient.getVitalSigns().forEach(sv -> sv.setPatient(newPatient));
        return new PatientDTO(genRepository.save(newPatient));
    }

    @Transactional
    public List<PatientDTO> addPatientList(List<Patient> patientList){
        List<PatientDTO> list = new ArrayList<>();
        patientList.forEach(patient -> {
            if(patient.getId() == null){
                list.add(this.addPatient(patient));
            } else {
                list.add(this.updatePatient(patient.getId(), patient));
            }
        });
        return list;
    }

    @Transactional
    public PatientDTO addVitalSign(Integer id, VitalSign svNuevo){
        Patient foundPatient = genRepository.findById(id).orElse(null);
        if(foundPatient != null){
            foundPatient.addSignoVital(svNuevo);
            return new PatientDTO(genRepository.save(foundPatient));
        }
        return null;
    }

    @Transactional
    public PatientDTO updatePatient(Integer id, Patient updatedPatient){
        Patient foundPatient = genRepository.findById(id).orElse(null);
        if(foundPatient != null){
            foundPatient.setFullName(updatedPatient.getFullName());
            foundPatient.setBirthDate(updatedPatient.getBirthDate());
            return new PatientDTO(foundPatient);
        }
        return null;
    }

    public void deletePatient(Integer id){
        genRepository.deleteById(id);
    }
}
