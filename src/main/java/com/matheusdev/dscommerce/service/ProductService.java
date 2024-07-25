package com.matheusdev.dscommerce.service;

import com.matheusdev.dscommerce.dto.ProductDTO;
import com.matheusdev.dscommerce.entities.Product;
import com.matheusdev.dscommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = new ProductDTO(product);

        return productDTO;
    }
}
