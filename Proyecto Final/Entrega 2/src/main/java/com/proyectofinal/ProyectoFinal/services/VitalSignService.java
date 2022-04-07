package com.proyectofinal.ProyectoFinal.services;

import com.proyectofinal.ProyectoFinal.entities.Patient;
import com.proyectofinal.ProyectoFinal.entities.VitalSign;
import com.proyectofinal.ProyectoFinal.repositories.VitalSignRepository;
import com.proyectofinal.ProyectoFinal.responseDTO.VitalSignDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VitalSignService {
    @Autowired
    private VitalSignRepository vitalSignRepository;

    public List<VitalSignDTO> getVitalSigns(){
        return vitalSignRepository.findAll()
                .stream()
                .map(VitalSignDTO::new)
                .collect(Collectors.toList());
    }

    public List<VitalSignDTO> getVitalSignsByPatient(Patient patient){
        return vitalSignRepository.findByPatient(patient)
                .stream()
                .map(VitalSignDTO::new)
                .collect(Collectors.toList());
    }

    public List<VitalSignDTO> updateVitalSigns(VitalSign vitalSign, Integer id){
        VitalSign sv = vitalSignRepository.findById(id).orElse(null);
        if(sv != null){
            sv.setVitalSign(vitalSign.getVitalSign());
            sv.setValor(vitalSign.getValor());
            sv = vitalSignRepository.save(sv);
            return sv.getPatient().getVitalSigns()
                    .stream()
                    .map(VitalSignDTO::new)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public void deleteVitalSign(Integer id){
        VitalSign sv = vitalSignRepository.findById(id).orElse(null);
        if(sv != null)
            vitalSignRepository.deleteById(id);
    }
}
