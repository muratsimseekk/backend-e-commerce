package com.workintech.backend.controller;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;
import com.workintech.backend.service.StoreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {

    private StoreService storeService;

    @GetMapping("/")
    public List<StoreResponse> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public StoreResponse findById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @PostMapping("/")
    public StoreResponse save(@RequestBody Store store){
        return storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public StoreResponse delete(@PathVariable Long id){
        return storeService.delete(id);
    }

}
