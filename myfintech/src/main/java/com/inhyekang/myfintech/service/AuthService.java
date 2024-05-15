package com.inhyekang.myfintech.service;

import com.inhyekang.myfintech.dto.request.SignInRequest;
import com.inhyekang.myfintech.dto.response.TokensResponse;
import com.inhyekang.myfintech.exception.UserNotFoundException;
import com.inhyekang.myfintech.repository.UserRepository;
import com.inhyekang.myfintech.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    @Transactional
    public TokensResponse signIn(SignInRequest request) {

        userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return jwtTokenProvider.createTokens(request.getEmail());
    }

    @Transactional
    public TokensResponse reissue(String refreshToken) {

        return jwtTokenProvider.reissue(refreshToken);
    }

}