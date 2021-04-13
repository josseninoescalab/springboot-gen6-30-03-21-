package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.Archivo;
import com.escalab.mediappbackend.repository.ArchivoRepository;
import com.escalab.mediappbackend.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArchivoServiceImpl implements ArchivoService {
	
	@Autowired
	private ArchivoRepository archivoRepository;
	
	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = archivoRepository.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}
	
	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		Optional<Archivo> op = archivoRepository.findById(idArchivo);
		return op.isPresent() ? op.get().getValue() : new byte[0];
	}
}
