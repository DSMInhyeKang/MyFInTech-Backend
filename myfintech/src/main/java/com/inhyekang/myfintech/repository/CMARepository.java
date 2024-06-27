package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.product.CMA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CMARepository extends CrudRepository<CMA, Long> {
    List<CMA> findAll();
}
