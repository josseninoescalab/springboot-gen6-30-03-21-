package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

   @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable("id") Integer id) throws Exception {
        return pacienteService.findById(id);
    }

    @PostMapping
    public Paciente save(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @PutMapping
    public Paciente update(@RequestBody Paciente paciente){
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        pacienteService.deleteById(id);
        return "Paciente eliminado correctamente";
    }
}
