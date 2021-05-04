package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.ResetToken;
import com.escalab.mediappbackend.repository.ResetTokenRepository;
import com.escalab.mediappbackend.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}
