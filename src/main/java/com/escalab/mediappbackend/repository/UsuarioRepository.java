package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUserName(String username);

}
