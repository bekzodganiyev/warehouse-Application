package com.bek.warehouse.repository;

import com.bek.warehouse.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    boolean existsByName(String name);

}
