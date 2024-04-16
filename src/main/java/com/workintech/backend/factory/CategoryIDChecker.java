package com.workintech.backend.factory;

import com.workintech.backend.dto.CategoryResponse;
import com.workintech.backend.exception.CategoryException;
import org.springframework.http.HttpStatus;

public class CategoryIDChecker {

    public static void idChecker (Long id){
        if (id<0) {
            throw new CategoryException("Category ID degeri 0 dan kucuk olamaz . ID : " + id , HttpStatus.BAD_REQUEST);
        }
    }
}
