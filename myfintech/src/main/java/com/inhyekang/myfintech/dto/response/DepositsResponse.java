package com.inhyekang.myfintech.dto.response;

import com.inhyekang.myfintech.entity.product.Deposit;
import com.inhyekang.myfintech.entity.product.Saving;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DepositsResponse {
    private List<Deposit> regular;
    private List<Deposit> parking;
    private List<Deposit> mmda;

    public static DepositsResponse of(List<Deposit> regular, List<Deposit> parking, List<Deposit> mmda) {
        return  DepositsResponse
                .builder()
                .regular(regular)
                .parking(parking)
                .mmda(mmda)
                .build();

    }
}