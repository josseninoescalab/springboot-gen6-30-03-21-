package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public ResponseEntity<Paciente> findById(Integer id) {
        try {
            Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
            if(optionalPaciente.isPresent()){
                return new ResponseEntity<>(optionalPaciente.get(), HttpStatus.OK);
            }else{
             return new ResponseEntity<>(new Paciente(), HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(new Paciente(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public ResponseEntity<Paciente> save(Paciente paciente) {
        try{
            Paciente pac = pacienteRepository.save(paciente);
            return new ResponseEntity<>(pac, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Paciente(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
