package com.inhyekang.myfintech.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInRequest {
    @NotNull(message = "email을 입력해주세요")
    private String email;

    @NotNull(message = "sub을 입력해주세요")
    private String sub;
}