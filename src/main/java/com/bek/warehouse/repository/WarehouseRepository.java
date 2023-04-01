package com.bek.warehouse.repository;

import com.bek.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    boolean existsByName(String name);

}
