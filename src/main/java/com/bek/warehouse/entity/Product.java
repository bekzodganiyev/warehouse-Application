package com.bek.warehouse.entity;

import com.bek.warehouse.entity.template.AbsEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@PackagePrivate
public class Product extends AbsEntity {

    @ManyToOne(optional = false)
    Category category;

    @OneToOne
    Attachment attachment;

    String code;

    @ManyToOne(optional = false)
    Measurement measurement;



}
