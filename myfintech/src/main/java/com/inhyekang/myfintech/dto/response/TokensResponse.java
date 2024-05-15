package com.inhyekang.myfintech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TokensResponse {
    private String accessToken;

    private String refreshToken;
}