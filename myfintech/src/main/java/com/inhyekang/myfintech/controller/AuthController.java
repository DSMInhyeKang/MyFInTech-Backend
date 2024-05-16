package com.inhyekang.myfintech.controller;

import com.inhyekang.myfintech.dto.request.RegisterRequest;
import com.inhyekang.myfintech.dto.request.SignInRequest;
import com.inhyekang.myfintech.dto.response.FindUserInfoResponse;
import com.inhyekang.myfintech.dto.response.SearchUserResponse;
import com.inhyekang.myfintech.dto.response.TokensResponse;
import com.inhyekang.myfintech.service.AuthService;
import com.inhyekang.myfintech.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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