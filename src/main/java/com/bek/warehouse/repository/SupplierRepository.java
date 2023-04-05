package com.bek.warehouse.repository;

import com.bek.warehouse.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

}
