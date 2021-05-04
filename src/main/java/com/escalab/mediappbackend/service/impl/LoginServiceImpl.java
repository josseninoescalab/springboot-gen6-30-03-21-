package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.Usuario;
import com.escalab.mediappbackend.repository.LoginRepository;
import com.escalab.mediappbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository repo;

    @Override
    public int cambiarClave(String clave, String nombre) {
        int rpta = 0;
        try {
            repo.cambiarClave(clave, nombre);
            rpta = 1;
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

    @Override
    public Usuario verificarNombreUsuario(String usuario) throws Exception {
        Usuario us = null;
        try {
            us = repo.verificarNombreUsuario(usuario);
            us = us != null ? us : new Usuario();
        } catch (Exception e) {
            us = new Usuario();
        }
        return us;
    }
}
