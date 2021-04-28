package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService extends ICRUD<Paciente> {
    Page<Paciente> listarPageable(Pageable pageable);
}
