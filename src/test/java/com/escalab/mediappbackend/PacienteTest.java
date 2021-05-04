package com.escalab.mediappbackend;

import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.repository.PacienteRepository;
import com.escalab.mediappbackend.service.PacienteService;
import com.escalab.mediappbackend.service.impl.PacienteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PacienteTest {

    @Mock
    PacienteRepository repo;

    @InjectMocks
    PacienteService pacienteService = new PacienteServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getPaciente() throws Exception {
        Integer pacienteId = null;
        when(repo.findById(pacienteId)).thenReturn(Optional.of(new Paciente()));
        Paciente paciente = pacienteService.findById(pacienteId);
        assertEquals(paciente.getIdPaciente(), pacienteId);
    }
}
