package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Currency;
import com.bek.warehouse.entity.Warehouse;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.CurrencyService;
import com.bek.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    // Add warehouse
    @PostMapping
    public Result addMeasurement(@RequestBody Warehouse warehouse) {
        return warehouseService.addWarehouse(warehouse);
    }

    // Get all currencies
    @GetMapping
    public Result getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }

    // Get one warehouse
    @GetMapping("/{id}")
    public Result getWarehouseById(@PathVariable Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    // Edit warehouse
    @PutMapping("/{id}")
    public Result editWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        return warehouseService.editWarehouse(id, warehouse);
    }

    // Delete warehouse
    @DeleteMapping("/{id}")
    public Result deleteWarehouse(@PathVariable Integer id) {
        return warehouseService.deleteWarehouse(id);
    }

}
