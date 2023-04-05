package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Supplier;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @GetMapping
    public Result getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @GetMapping("/{id}")
    public Result getSupplierById(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }

    @PutMapping("/{id}")
    public Result editSupplier(@PathVariable Integer id,@RequestBody Supplier supplier){
        return supplierService.editSupplier(id,supplier);
    }

    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        return supplierService.deleteSupplier(id);
    }

}
