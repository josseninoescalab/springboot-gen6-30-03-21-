package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.ResetToken;

public interface ResetTokenService {

    ResetToken findByToken(String token);

    void guardar(ResetToken token);

    void eliminar(ResetToken token);
}
