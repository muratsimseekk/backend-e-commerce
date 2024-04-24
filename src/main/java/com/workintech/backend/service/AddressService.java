package com.workintech.backend.service;


import com.workintech.backend.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();
    Address findById(Long id);

    Address save(Address address) ;

    Address delete(Long id);


}
