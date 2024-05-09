package com.inhyekang.myfintech.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String header;
    private final String prefix;
    private final String secret;
    private final Long access;
    private final Long refresh;
}