package com.bek.warehouse.entity;

import com.bek.warehouse.entity.template.AbsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Supplier extends AbsEntity {
    @Column(unique = true, nullable = false)
    private String phoneNumber;
}
