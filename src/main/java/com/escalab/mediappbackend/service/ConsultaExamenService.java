package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.ConsultaExamen;

import java.util.List;

public interface ConsultaExamenService {
	
	
	List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta);
	
	

}
