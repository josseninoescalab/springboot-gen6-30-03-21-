package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {

    //from ResetToken where token = :?
    ResetToken findByToken(String token);
}
