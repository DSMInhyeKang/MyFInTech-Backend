package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.user.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String Token);
    Optional<RefreshToken> findByEmail(String email);
}
