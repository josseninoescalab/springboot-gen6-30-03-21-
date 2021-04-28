package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.exception.ModeloNotFoundException;
import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.repository.PacienteRepository;
import com.escalab.mediappbackend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente findById(Integer id) throws Exception {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(!optionalPaciente.isPresent()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return optionalPaciente.get();
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente save(Paciente paciente) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Paciente>> violations = validator.validate(paciente);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
        Paciente pac = pacienteRepository.save(paciente);
        return pac;
    }

    @Override
    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(!optionalPaciente.isPresent()){
            throw new Exception("ID NO ENCONTRADO: " + id);
        }
        pacienteRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<Paciente> listarPageable(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }
}
