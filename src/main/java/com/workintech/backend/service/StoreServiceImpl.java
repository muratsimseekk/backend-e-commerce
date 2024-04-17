package com.workintech.backend.service;

import com.workintech.backend.dto.StoreResponse;
import com.workintech.backend.entity.Store;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.StoreRepository;
import com.workintech.backend.util.StoreDtoConvertion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{

    private StoreRepository storeRepository;
    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreResponse save(Store store) {
         storeRepository.save(store);
        return StoreDtoConvertion.converStore(store);
    }

    @Override
    public List<StoreResponse> findAll() {
        List<Store> storeList = storeRepository.findAll();
        return StoreDtoConvertion.converStoreList(storeList);
    }

    @Override
    public StoreResponse findById(Long id) {

        Optional<Store> optional = storeRepository.findById(id);
       if (optional.isPresent()){
           Store store = optional.get();
           return StoreDtoConvertion.converStore(store);
       }
       throw new CommonException("Store bulunamadi . Store ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public StoreResponse delete(Long id) {

        Optional<Store> optional = storeRepository.findById(id);
        if (optional.isPresent()){
             storeRepository.delete(optional.get());
             return StoreDtoConvertion.converStore(optional.get());
        }
        throw new CommonException("Store bulunamadi . Store ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Store findByIDStore(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()){
            return store.get();
        }
        throw new CommonException("Bu id de bir store bulunamadi . ID :" + id , HttpStatus.NOT_FOUND);
    }
}
