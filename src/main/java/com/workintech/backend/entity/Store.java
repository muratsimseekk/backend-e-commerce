package com.workintech.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "store" , schema = "ecommercebackend")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "tax_no")
    private Long taxNo;

    @Column(name = "bank_account")
    private Long bankAccount;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "store")
    private List<Product> products = new ArrayList<>();

}
