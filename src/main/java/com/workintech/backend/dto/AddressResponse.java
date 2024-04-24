package com.workintech.backend.dto;

public record AddressResponse(Long id , String title , String name ,String phone , String city, String district
        ,String neighborhood , String address , Long userID ) {
}
