package com.workintech.backend.service;

import com.workintech.backend.entity.Category;
import com.workintech.backend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("Bu id de bir category bulunamadi . ID :" + id);
    }

    @Override
    public Category delete(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            categoryRepository.delete(optional.get());
            return optional.get();
        }
        throw new RuntimeException("Bu id de bir category bulunamadi . ID :" + id);
    }
}
