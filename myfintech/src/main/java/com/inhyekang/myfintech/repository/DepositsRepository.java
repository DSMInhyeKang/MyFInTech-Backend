package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.product.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositsRepository extends CrudRepository<Deposit, Long> {
    List<Deposit> findAllDeposits();

    List<Deposit> findByType(String type);
}
