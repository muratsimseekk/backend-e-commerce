package com.workintech.backend.controller;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Category;
import com.workintech.backend.entity.Product;
import com.workintech.backend.entity.Store;
import com.workintech.backend.service.CategoryService;
import com.workintech.backend.service.ProductService;
import com.workintech.backend.service.StoreService;
import com.workintech.backend.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    private StoreService storeService;


    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, StoreService storeService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.storeService = storeService;
    }

    @GetMapping("/")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }


    @GetMapping("/param")
    public List<ProductResponse> sortProducts(@RequestParam String sort){
        return productService.filtreProduct(sort);
    }

    @GetMapping("/filter/param")
    public List<ProductResponse> filterByName(@RequestParam String filter){
        return productService.filterByName(filter);
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("/{categoryID}/{storeID}")
    public ProductResponse save(@RequestBody Product product ,@PathVariable Long categoryID , @PathVariable Long storeID){

        Category category = categoryService.findByIdCategory(categoryID);

        Store store = storeService.findByIDStore(storeID);

        product.setCategory(category);
        product.setStore(store);

        productService.save(product);

        category.addProduct(product);
        store.addProduct(product);

         return ProductDtoConvertion.convertProduct(product);
    }

    @DeleteMapping("{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }


}
