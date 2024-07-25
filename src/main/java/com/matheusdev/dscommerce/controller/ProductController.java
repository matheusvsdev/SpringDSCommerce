package com.matheusdev.dscommerce.controller;

import com.matheusdev.dscommerce.dto.ProductDTO;
import com.matheusdev.dscommerce.entities.Product;
import com.matheusdev.dscommerce.repository.ProductRepository;
import com.matheusdev.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        ProductDTO productDTO = productService.findById(id);
        return productDTO;
    }
}
