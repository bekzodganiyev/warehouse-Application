package com.bek.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalTime date;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private  Supplier supplier;

    @ManyToOne
    private Currency currency;

    private Integer factureNumber;

    @Column(unique = true, nullable = false)
    private String code;

    public Input(LocalTime date, Warehouse warehouse, Supplier supplier, Currency currency, Integer factureNumber, String code) {
        this.date = date;
        this.warehouse = warehouse;
        this.supplier = supplier;
        this.currency = currency;
        this.factureNumber = factureNumber;
        this.code = code;
    }
}
