package com.inhyekang.myfintech.dto.response;

import com.inhyekang.myfintech.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FindUserInfoResponse {

    private String name;

    private String email;

    private String sub;

    public static FindUserInfoResponse of(User user) {

        return FindUserInfoResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .sub(user.getSub())
                .build();
    }
}