package com.workintech.backend.service;

import com.workintech.backend.entity.Store;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class StoreServiceImpl implements StoreService{

    private StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(Long id) {

        Optional<Store> optional = storeRepository.findById(id);
       if (optional.isPresent()){
           return optional.get();
       }
       throw new CommonException("Store bulunamadi . Store ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Store delete(Long id) {

        Optional<Store> optional = storeRepository.findById(id);
        if (optional.isPresent()){
             storeRepository.delete(optional.get());
             return optional.get();
        }
        throw new CommonException("Store bulunamadi . Store ID : " + id , HttpStatus.NOT_FOUND);
    }
}
