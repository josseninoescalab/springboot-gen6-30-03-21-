package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.Medico;
import com.escalab.mediappbackend.repository.MedicoRepository;
import com.escalab.mediappbackend.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public Medico save(Medico obj) {
		return medicoRepository.save(obj);
	}
	
	@Override
	public Medico update(Medico obj) {
		return medicoRepository.save(obj);
	}
	
	@Override
	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}
	
	@Override
	public Medico findById(Integer id) throws Exception {
		Optional<Medico> op = medicoRepository.findById(id);
		if (!op.isPresent()) {
			throw new Exception("ID NO ENCONTRADO" + id);
		}
		return op.get();
 	}
	
	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Medico> op = medicoRepository.findById(id);
		if (!op.isPresent()) {
			throw new Exception("ID NO ENCONTRADO" + id);
		}
		medicoRepository.deleteById(id);
		return true;
	}
}
