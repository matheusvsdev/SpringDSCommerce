package com.matheusdev.dscommerce.service;


import com.matheusdev.dscommerce.dto.CategoryDTO;
import com.matheusdev.dscommerce.entities.Category;
import com.matheusdev.dscommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> listCategories = categoryRepository.findAll();
        return listCategories.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
