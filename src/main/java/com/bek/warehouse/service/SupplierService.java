package com.bek.warehouse.service;

import com.bek.warehouse.entity.Supplier;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier) {
        if ((supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber()))&&(supplier.getPhoneNumber()==null)) {
            return new Result("Phonr number is already exist or empty",false);
        }
        Supplier savedSupplier = supplierRepository.save(supplier);
        return new Result("Saved!!!",true,savedSupplier);
    }

    public Result getAllSupplier() {
        return new Result("All supplier",true, supplierRepository.findAll());
    }

    public Result getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
//        return optionalSupplier.isPresent()?new Result("Supplier by id",true,optionalSupplier.get()):new Result("Supplier not found",false);
        return optionalSupplier.map(supplier -> new Result("Supplier by id", true, supplier)).orElseGet(() -> new Result("Supplier not found", false));
    }

    public Result editSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier editingSupplier = optionalSupplier.get();
            if ((editingSupplier.getPhoneNumber().equals(supplier.getPhoneNumber()))&&supplier.getPhoneNumber()==null) {
                editingSupplier.setName(supplier.getName());
                editingSupplier.setActive(supplier.isActive());
            } else {
                editingSupplier.setName(supplier.getName());
                editingSupplier.setActive(supplier.isActive());
                editingSupplier.setPhoneNumber(supplier.getPhoneNumber());
            }
            Supplier editedSupplier = supplierRepository.save(editingSupplier);
            return new Result("Edited",true,editedSupplier);
        }
        return new Result("Not Edited",false);
    }

    public Result deleteSupplier(Integer id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return new Result("Deleted ",true);
        }
        return new Result("Supplier not found",false);
    }
}

