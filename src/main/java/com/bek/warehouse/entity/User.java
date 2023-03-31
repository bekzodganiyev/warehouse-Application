package com.bek.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
@PackagePrivate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(unique = true, nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String code;

    @ManyToMany
    Set<Warehouse> warehouses;

    Boolean isActive;
}
