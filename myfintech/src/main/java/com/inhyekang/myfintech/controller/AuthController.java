package com.inhyekang.myfintech.controller;

import com.inhyekang.myfintech.dto.request.SignInRequest;
import com.inhyekang.myfintech.dto.response.TokensResponse;
import com.inhyekang.myfintech.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    public TokensResponse signIn(@Valid @RequestBody SignInRequest request) {
        return authService.signIn(request);
    }

    @PutMapping("/reissue")
    public TokensResponse reissue(@RequestHeader(name = "X-Refresh-Token") String refreshToken) {
        return authService.reissue(refreshToken);
    }
}