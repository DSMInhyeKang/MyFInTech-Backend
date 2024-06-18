package com.inhyekang.myfintech.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "name을 입력해주세요")
    private String name;

    @NotBlank(message = "email을 입력해주세요")
    private String email;

    @NotBlank(message = "sub을 입력해주세요")
    private String sub;
}