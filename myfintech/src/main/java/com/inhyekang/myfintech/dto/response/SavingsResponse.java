package com.inhyekang.myfintech.dto.response;

import com.inhyekang.myfintech.entity.product.Saving;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SavingsResponse {
    private List<Saving> regular;
    private List<Saving> free;
    private List<Saving> youth;
    private List<Saving> soldier;

    public static SavingsResponse of(List<Saving> regular, List<Saving> free, List<Saving> youth, List<Saving> soldier) {
        return  SavingsResponse
                .builder()
                .regular(regular)
                .free(free)
                .youth(youth)
                .soldier(soldier)
                .build();

    }
}