package com.proyectofinal.ProyectoFinal.services;

import com.proyectofinal.ProyectoFinal.entities.Paciente;
import com.proyectofinal.ProyectoFinal.entities.SignoVital;
import com.proyectofinal.ProyectoFinal.repositories.PacienteRepository;
import com.proyectofinal.ProyectoFinal.responseDTO.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDTO> getPacientes(){
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .collect(Collectors.toList());
    }

    public PacienteDTO getPacienteById(Integer id){
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElse(null);
        if(pacienteEncontrado != null)
            return new PacienteDTO(pacienteEncontrado);
        return null;
    }

    public PacienteDTO getPacienteByFullName(String fullName){
        Paciente pacienteEncontrado = pacienteRepository.findByFullName(fullName);
        if(pacienteEncontrado != null)
            return new PacienteDTO(pacienteEncontrado);
        return null;
    }

    public PacienteDTO addPaciente(Paciente pacienteNuevo){
        pacienteNuevo.getSignosVitales().forEach(sv -> sv.setPaciente(pacienteNuevo));
        return new PacienteDTO(pacienteRepository.save(pacienteNuevo));
    }

    public PacienteDTO addSignoVital(Integer id, SignoVital svNuevo){
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElse(null);
        if(pacienteEncontrado != null){
            pacienteEncontrado.addSignoVital(svNuevo);
            return new PacienteDTO(pacienteRepository.save(pacienteEncontrado));
        }
        return null;
    }

    public PacienteDTO updatePaciente(Integer id, Paciente pacienteActualizado){
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElse(null);
        if(pacienteEncontrado != null){
            pacienteEncontrado.setFullName(pacienteActualizado.getFullName());
            pacienteEncontrado.setBirthDate(pacienteActualizado.getBirthDate());
            return new PacienteDTO(pacienteEncontrado);
        }
        return null;
    }

    public void deletePaciente(Integer id){
        pacienteRepository.deleteById(id);
    }
}
