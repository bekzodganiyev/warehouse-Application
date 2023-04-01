package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Currency;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    // Add currency
    @PostMapping
    public Result addMeasurement(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    // Get all currencies
    @GetMapping
    public Result getAllCurrency() {
        return currencyService.getAllCurrency();
    }

    // Get one currency
    @GetMapping("/{id}")
    public Result getCurrencyById(@PathVariable Integer id) {
        return currencyService.getCurrencyById(id);
    }

    // Edit currency
    @PutMapping("/{id}")
    public Result editCurrency(@PathVariable Integer id, @RequestBody Currency currency) {
        return currencyService.editCurrency(id, currency);
    }

    // Delete currency
    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        return currencyService.deleteCurrency(id);
    }

}
