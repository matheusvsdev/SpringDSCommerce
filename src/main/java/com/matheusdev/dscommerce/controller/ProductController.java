package com.matheusdev.dscommerce.controller;

import com.matheusdev.dscommerce.dto.ProductDTO;
import com.matheusdev.dscommerce.entities.Product;
import com.matheusdev.dscommerce.repository.ProductRepository;
import com.matheusdev.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) { //Pageable paginar lista por quantidade escolhida
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        productDTO = productService.addProduct(productDTO);
        return productDTO;
    }   
}
