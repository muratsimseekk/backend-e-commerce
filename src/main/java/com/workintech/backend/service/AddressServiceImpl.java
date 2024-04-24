package com.workintech.backend.service;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.AddressRepository;
import com.workintech.backend.util.AddressDtoConvertion;
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
    public List<AddressResponse> findAll() {

        //List<Address> addresses = addressRepository.findAll();

        return AddressDtoConvertion.convertAddressList(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            return AddressDtoConvertion.convertAddress(address.get());
        }

        throw new CommonException("Girilen ID de bir address bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse save(Address address) {
         addressRepository.save(address);
         return AddressDtoConvertion.convertAddress(address);
    }

    @Override
    public AddressResponse delete(Long id) {

        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            addressRepository.delete(address.get());
            return AddressDtoConvertion.convertAddress(address.get());
        }

        throw new CommonException("Girilen ID de bir address bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);

    }

    @Override
    public Address findByAddressId(Long id) {

        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()){
            addressRepository.delete(address.get());
            return  address.get();
        }

        throw new CommonException("Girilen ID de bir address bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

}
