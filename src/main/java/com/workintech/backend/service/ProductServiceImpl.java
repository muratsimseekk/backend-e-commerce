package com.workintech.backend.service;

import com.workintech.backend.entity.Product;
import com.workintech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("Bu id de bir Product bulunamadi . ID :" + id);
    }

    @Override
    public Product delete(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()){
            productRepository.delete(optional.get());
            return optional.get();
        }
        throw new RuntimeException("Bu id de bir Product bulunamadi . ID :" + id);
    }
}
