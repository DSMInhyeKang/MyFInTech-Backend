package com.inhyekang.myfintech.controller;

import com.inhyekang.myfintech.dto.response.DepositsResponse;
import com.inhyekang.myfintech.dto.response.SavingsResponse;
import com.inhyekang.myfintech.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/deposits")
    public DepositsResponse fetchAllDeposits() { return productService.fetchAllDeposits(); }

    @GetMapping("/savings")
    public SavingsResponse fetchAllSavings() { return productService.fetchAllSavings(); }
}