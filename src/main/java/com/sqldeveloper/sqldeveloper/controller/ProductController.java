package com.sqldeveloper.sqldeveloper.controller;

import com.sqldeveloper.sqldeveloper.service.ProductServiceImpl;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public double avgPriceProduct()
    {
        return productService.avgPriceProduct();
    }
    @GetMapping("/avgPriceProducts")
    public double avgPriceProducts()
    {
        return productService.avgPriceProducts();
    }
}
