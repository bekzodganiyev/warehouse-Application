package com.bek.warehouse.service;

import com.bek.warehouse.entity.Warehouse;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse) {
        if (warehouseRepository.existsByName(warehouse.getName())) {
            return new Result("This warehouse is already exist. SORRY !!!", false);
        }
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);
        return new Result("SUCCESSFULLY SAVED !!!", true, savedWarehouse);
    }

    public Result getAllWarehouse() {
        return new Result("All warehouse", true, warehouseRepository.findAll());
    }

    public Result getWarehouseById(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
//        return optionalWarehouse.isPresent()?new Result("OK",true,optionalMeasurement.get()):new Result("Not found",false);
        return optionalWarehouse.map(warehouse -> new Result("OK", true, warehouse)).orElseGet(() -> new Result("Not found", false));
    }

    public Result editWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse editingWarehouse = optionalWarehouse.get();
            editingWarehouse.setName(warehouse.getName());
            Warehouse savedWarehouse = warehouseRepository.save(editingWarehouse);
            return new Result("Edited !!!", true, savedWarehouse);
        }
        return new Result("Not found", false);
    }

    public Result deleteWarehouse(Integer id) {
        if (warehouseRepository.existsById(id)) {
            warehouseRepository.deleteById(id);
            return new Result("Deleted !!!", true);
        }
        return new Result("This measurement is not exist !!!", false);
    }
}
