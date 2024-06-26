package com.workintech.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "user" , schema = "ecommercebackend")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
    private Store store;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private List<Card> cardList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();
}
