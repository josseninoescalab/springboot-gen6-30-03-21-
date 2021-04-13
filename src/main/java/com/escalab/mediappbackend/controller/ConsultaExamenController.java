package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.ConsultaExamen;
import com.escalab.mediappbackend.service.ConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultaexamenes")
public class ConsultaExamenController {

	@Autowired
	private ConsultaExamenService service;

	@GetMapping(value = "/{idConsulta}")
	public ResponseEntity<List<ConsultaExamen>> listar(@PathVariable("idConsulta") Integer idconsulta) {
		List<ConsultaExamen> consultasexamen = new ArrayList<>();
		consultasexamen = service.listarExamenesPorConsulta(idconsulta);
		return new ResponseEntity<List<ConsultaExamen>>(consultasexamen, HttpStatus.OK);
	}
}
