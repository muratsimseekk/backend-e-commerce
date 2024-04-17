package com.workintech.backend.service;

import com.workintech.backend.dto.ProductResponse;
import com.workintech.backend.entity.Product;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.factory.GlobalIdChecker;
import com.workintech.backend.repository.ProductRepository;
import com.workintech.backend.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service



public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse save(Product product) {
         productRepository.save(product);
         return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products= productRepository.findAll();
        return ProductDtoConvertion.convertProductList(products);
    }
    @Override
    public List<ProductResponse> findAllByPriceAsc() {
        List<Product> products = productRepository.sortByPriceAsc();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public List<ProductResponse> findAllByPriceDesc() {
        List<Product> products=  productRepository.sortByPriceDesc();
        return ProductDtoConvertion.convertProductList(products);
    }


    @Override
    public List<ProductResponse> filterByName(String filter) {
        List<Product> products = productRepository.filterByName(filter);

        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        GlobalIdChecker.productIDChecker(id);

        if (optional.isPresent()){
            return ProductDtoConvertion.convertProduct(optional.get());
        }
        throw new CommonException("Girilen id li Product bulunamadi . ID : " + id , HttpStatus.BAD_REQUEST);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        GlobalIdChecker.productIDChecker(id);

        if (optional.isPresent()){
            productRepository.delete(optional.get());
            return ProductDtoConvertion.convertProduct(optional.get());
        }
        throw new RuntimeException("Bu id de bir Product bulunamadi . ID :" + id);
    }

    @Override
    public List<ProductResponse> filtreProduct(String sort) {

        if (sort.equals("asc")){
           return findAllByPriceAsc();
        }
        else if (sort.equals("desc")){
            return findAllByPriceDesc();
        }
        throw new CommonException("Sort islemi icin url hatasi ." , HttpStatus.NOT_FOUND);
    }


}
