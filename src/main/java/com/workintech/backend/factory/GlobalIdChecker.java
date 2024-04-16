package com.workintech.backend.factory;

import com.workintech.backend.exception.CategoryException;
import org.springframework.http.HttpStatus;

public class GlobalIdChecker {

    public static void categoryIDChecker (Long id){
        if (id<0) {
            throw new CategoryException("Category ID degeri 0 dan kucuk olamaz . ID : " + id , HttpStatus.BAD_REQUEST);
        }
    }

    public static void productIDChecker (Long id){
        if (id<0) {
            throw new CategoryException("Product ID degeri 0 dan kucuk olamaz . ID : " + id , HttpStatus.BAD_REQUEST);
        }
    }


}
