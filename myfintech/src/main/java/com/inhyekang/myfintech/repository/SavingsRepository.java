package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.product.Saving;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsRepository extends CrudRepository<Saving, Long> {
    List<Saving> findAll();

    List<Saving> findByType(String type);
}
