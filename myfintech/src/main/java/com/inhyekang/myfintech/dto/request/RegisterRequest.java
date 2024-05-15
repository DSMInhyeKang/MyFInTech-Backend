package com.inhyekang.myfintech.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {
    @NotNull(message = "name을 입력해주세요")
    private String name;

    @NotNull(message = "email을 입력해주세요")
    private String email;

    @NotNull(message = "sub을 입력해주세요")
    private String sub;
}