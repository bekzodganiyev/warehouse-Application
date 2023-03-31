package com.bek.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PackagePrivate
public class OutputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    Product product;

    @Column(nullable = false)
    Double amount;

    Double price;

    @ManyToOne
    Output output;
}
