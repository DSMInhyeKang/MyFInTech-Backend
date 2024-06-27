package com.inhyekang.myfintech.dto.response;

import com.inhyekang.myfintech.entity.product.CMA;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CMAResponse {
    List<CMA> cp;
    List<CMA> rp;
    List<CMA> mmf;
    List<CMA> mmw;

    public static CMAResponse of(List<CMA> cp, List<CMA> rp, List<CMA> mmf, List<CMA> mmw) {
        return CMAResponse
                .builder()
                .cp(cp)
                .rp(rp)
                .mmf(mmf)
                .mmw(mmw)
                .build();
    }
}
