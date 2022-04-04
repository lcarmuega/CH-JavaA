package com.proyectofinal.ProyectoFinal.services;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import com.proyectofinal.ProyectoFinal.entities.SignoVital;
import com.proyectofinal.ProyectoFinal.repositories.SignoVitalRepository;
import com.proyectofinal.ProyectoFinal.responseDTO.SignoVitalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignoVitalService {
    @Autowired
    private SignoVitalRepository signoVitalRepository;

    public List<SignoVitalDTO> getSignosVitales(){
        return signoVitalRepository.findAll()
                .stream()
                .map(SignoVitalDTO::new)
                .collect(Collectors.toList());
    }

    public List<SignoVitalDTO> getSignosVitalesByPaciente(Paciente paciente){
        return signoVitalRepository.findByPaciente(paciente)
                .stream()
                .map(SignoVitalDTO::new)
                .collect(Collectors.toList());
    }

    public List<SignoVitalDTO> updateSignosVitales(SignoVital signoVital, Integer id){
        SignoVital sv = signoVitalRepository.findById(id).orElse(null);
        if(sv != null){
            sv.setSignoVital(signoVital.getSignoVital());
            sv.setValor(signoVital.getValor());
            sv = signoVitalRepository.save(sv);
            return sv.getPaciente().getSignosVitales()
                    .stream()
                    .map(SignoVitalDTO::new)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public void deleteSignoVital(Integer id){
        SignoVital sv = signoVitalRepository.findById(id).orElse(null);
        if(sv != null)
            signoVitalRepository.deleteById(id);
    }
}
