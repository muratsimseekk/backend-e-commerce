package com.workintech.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.workintech.backend.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category" , schema = "ecommercebackend")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "img")
    private String img ;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "title")
    private String title ;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "category")
    private List<Product> products ;

    public void addProduct(Product product){
        if (products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }

}
