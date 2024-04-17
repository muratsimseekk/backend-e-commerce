package com.workintech.backend.controller;

import com.workintech.backend.entity.Store;
import com.workintech.backend.service.StoreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
@NoArgsConstructor
public class StoreController {

    private StoreService storeService;

    @GetMapping("/")
    public List<Store> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public Store findById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @PostMapping("/")
    public Store save(Store store){
        return storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public Store delete(@PathVariable Long id){
        return storeService.findById(id);
    }

}
