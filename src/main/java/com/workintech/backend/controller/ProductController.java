package com.workintech.backend.controller;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.entity.Product;
import com.workintech.backend.service.CategoryService;
import com.workintech.backend.service.ProductService;
import com.workintech.backend.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/{categoryID}")
    public ProductResponse save(@RequestBody Product product ,@PathVariable Long categoryID){

        Category category = categoryService.findByIdCategory(categoryID);

        product.setCategory(category);
        category.addProduct(product);

        categoryService.save(category);
        productService.save(product);

         return ProductDtoConvertion.convertProduct(product);
    }

    @DeleteMapping("{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }


}
