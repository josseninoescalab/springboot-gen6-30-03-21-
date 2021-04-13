package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.ConsultaExamen;
import com.escalab.mediappbackend.repository.ConsultaExamenRepository;
import com.escalab.mediappbackend.service.ConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {
	
	@Autowired
	private ConsultaExamenRepository consultaExamenRepository;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return consultaExamenRepository.listarExamenesPorConsulta(idconsulta);
	}
}
