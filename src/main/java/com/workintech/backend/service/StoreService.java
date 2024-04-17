package com.workintech.backend.service;

import com.workintech.backend.entity.Store;

import java.util.List;

public interface StoreService {
    Store save(Store store);
    List<Store> findAll();
    Store findById(Long id);
    Store delete(Long id);

}
