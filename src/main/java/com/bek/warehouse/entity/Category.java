package com.bek.warehouse.entity;

import com.bek.warehouse.entity.template.AbsEntity;
import jakarta.persistence.*;
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
public class Category extends AbsEntity {

    @ManyToOne
    Category parentCategory;
}
