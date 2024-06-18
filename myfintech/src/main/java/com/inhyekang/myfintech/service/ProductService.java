package com.inhyekang.myfintech.service;

import com.inhyekang.myfintech.dto.response.DepositsResponse;
import com.inhyekang.myfintech.dto.response.SavingsResponse;
import com.inhyekang.myfintech.entity.product.*;
import com.inhyekang.myfintech.repository.DepositsRepository;
import com.inhyekang.myfintech.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final DepositsRepository depositsRepository;
    private final SavingsRepository savingsRepository;

    @Transactional(readOnly = true)
    public DepositsResponse fetchAllDeposits() {
        List<Deposit> deposits = depositsRepository.findAll();

        return DepositsResponse.of(
                deposits.stream().filter(it -> it.getType() == DepositType.REGULAR).toList(),
                deposits.stream().filter(it -> it.getType() == DepositType.CMA).toList(),
                deposits.stream().filter(it -> it.getType() == DepositType.PARKING).toList(),
                deposits.stream().filter(it -> it.getType() == DepositType.MMDA).toList()
        );
    }

    @Transactional(readOnly = true)
    public SavingsResponse fetchAllSavings() {
        List<Saving> savings = savingsRepository.findAll();

        return SavingsResponse.of(
                savings.stream().filter(it -> it.getType() == SavingsType.REGULAR).toList(),
                savings.stream().filter(it -> it.getType() == SavingsType.FREE).toList(),
                savings.stream().filter(it -> it.getType() == SavingsType.YOUTH).toList(),
                savings.stream().filter(it -> it.getType() == SavingsType.SOLDIER).toList()
        );
    }
}
