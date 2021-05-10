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

import java.util.ArrayList;
import java.util.List;
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
        Integer pacienteId = 10;
        Paciente pc = new Paciente();
        pc.setIdPaciente(pacienteId);
        pc.setNombres("Prueba");
        when(repo.findById(pacienteId)).thenReturn(Optional.of(pc));
        Paciente paciente = pacienteService.findById(pacienteId);
        assertEquals(paciente.getIdPaciente(), pacienteId);
        assertEquals(paciente.getNombres(), "Prueba");
    }

    @Test
    public void getAllPaciente() throws Exception {
        Paciente pc = new Paciente();
        pc.setIdPaciente(10);
        pc.setNombres("Prueba");
        pc.setApellidos("Apellidos");
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(pc);
        when(repo.findAll()).thenReturn(pacientes);
        List<Paciente> pacienteList = pacienteService.findAll();
        //assertEquals(pacienteList.get(0).getIdPaciente(), pc.getIdPaciente());
        assertEquals(pacienteList.get(0).getNombres(), "Prueba");
        assertEquals(pacienteList.get(0).getApellidos(), "Apellidos");
    }
}
