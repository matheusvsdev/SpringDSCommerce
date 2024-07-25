package com.matheusdev.dscommerce.service;

import com.matheusdev.dscommerce.dto.ProductDTO;
import com.matheusdev.dscommerce.entities.Product;
import com.matheusdev.dscommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> listProduct = productRepository.findAll(pageable);
        return listProduct.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());

        product = productRepository.save(product);
        return new ProductDTO(product);
    }
}
