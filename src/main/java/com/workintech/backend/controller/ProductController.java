package com.workintech.backend.controller;

import com.workintech.backend.entity.Category;
import com.workintech.backend.entity.Product;
import com.workintech.backend.service.CategoryService;
import com.workintech.backend.service.ProductService;
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
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/{categoryID}")
    public Product save(@RequestBody Product product ,@PathVariable Long categoryID){

        Category category = categoryService.findById(categoryID);

        product.setCategory(category);
        category.addProduct(product);

        categoryService.save(category);
        productService.save(product);

         return product;
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }


}
