package com.workintech.backend.service;

import com.workintech.backend.entity.Address;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            return  address.get();
        }

        throw new CommonException("Girilen ID de bir address bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(Long id) {

        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            addressRepository.delete(address.get());
            return  address.get();
        }

        throw new CommonException("Girilen ID de bir address bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);

    }
}
