package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.Consulta;
import com.escalab.mediappbackend.repository.ConsultaRepository;
import com.escalab.mediappbackend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired	
	private ConsultaRepository consultaRepository;
	
	@Override
	public Consulta save(Consulta obj) {
		obj.getDetalleConsulta().forEach(det -> {
			det.setConsulta(obj);
		});
		return consultaRepository.save(obj);
	}

	@Override
	public Consulta update(Consulta obj) {
		return consultaRepository.save(obj);
	}

	@Override
	public List<Consulta> findAll() {
		return consultaRepository.findAll();
	}

	@Override
	public Consulta findById(Integer id) throws Exception {
		Optional<Consulta> op = consultaRepository.findById(id);
		if(!op.isPresent()) {
			throw new Exception("ID NO ENCONTRADO " + id);
		}
		return op.get();
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Consulta> obj = consultaRepository.findById(id);
		if(!obj.isPresent()) {
			throw new Exception("ID NO ENCONTRADO " + id);
		}
		consultaRepository.deleteById(id);
		return true;
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


