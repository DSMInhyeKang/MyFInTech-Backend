package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.product.Saving;
import com.inhyekang.myfintech.entity.product.Savings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsRepository extends CrudRepository<Saving, Long> {
    List<Saving> findAllSavings();

    List<Saving> findByType(String type);
}
