package com.inhyekang.myfintech.dto.response;

import com.inhyekang.myfintech.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SearchUserResponse {

    Long id;

    public static SearchUserResponse of(User user) {
        return SearchUserResponse
                .builder()
                .id(user.getId())
                .build();
    }
}