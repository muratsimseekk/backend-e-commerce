package com.workintech.backend.service;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.exception.CategoryException;
import com.workintech.backend.factory.CategoryIDChecker;
import com.workintech.backend.repository.CategoryRepository;
import com.workintech.backend.util.CategoryDtoConvertion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public CategoryResponse save(Category category) {
         categoryRepository.save(category);
         return CategoryDtoConvertion.convertCategory(category);
    }

    @Override
    public List<CategoryResponse> findAll() {
         List<Category> categories =  categoryRepository.findAll();

         return CategoryDtoConvertion.convertCategoryList(categories);

    }

    @Override
    public CategoryResponse findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        CategoryIDChecker.idChecker(id);

        if (optional.isPresent()){
            return CategoryDtoConvertion.convertCategory(optional.get());
        }

        throw new CategoryException("Girilen id li Category bulunamadi . ID : " + id , HttpStatus.BAD_REQUEST);
    }

    @Override
    public CategoryResponse delete(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        CategoryIDChecker.idChecker(id);

        if (optional.isPresent()){
            categoryRepository.delete(optional.get());
            return CategoryDtoConvertion.convertCategory(optional.get());
        }
        throw new CategoryException("Bu id de bir category bulunamadi . ID :" + id , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Category findByIdCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        CategoryIDChecker.idChecker(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new CategoryException("Bu id de bir category bulunamadi . ID :" + id , HttpStatus.BAD_REQUEST);
    }
}
