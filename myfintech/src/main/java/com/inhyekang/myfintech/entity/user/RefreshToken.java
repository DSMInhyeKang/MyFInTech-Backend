package com.inhyekang.myfintech.entity.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Builder
@RedisHash
public class RefreshToken implements Serializable {
    @Id
    private String email;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long expiration;

    public RefreshToken updateExpiration(Long expiration) {
        this.expiration = expiration;
        return this;
    }
}