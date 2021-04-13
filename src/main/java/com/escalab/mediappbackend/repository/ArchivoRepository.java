package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {
	
}
