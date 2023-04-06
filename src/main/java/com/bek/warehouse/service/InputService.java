package com.bek.warehouse.service;

import com.bek.warehouse.entity.Input;
import com.bek.warehouse.payload.InputDto;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.CurrencyRepository;
import com.bek.warehouse.repository.InputRepository;
import com.bek.warehouse.repository.SupplierRepository;
import com.bek.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addInput(InputDto inputDto) {
        if (!warehouseRepository.existsById(inputDto.getWarehouseId())) {
            return new Result("warehouse not found",false);
        }
        if (!supplierRepository.existsById(inputDto.getSupplierId())) {
            return new Result("supplier not found",false);
        }
        if (!currencyRepository.existsById(inputDto.getCurrencyId())) {
            return new Result("currency not found",false);
        }
        Input savedInput = inputRepository.save(new Input(
                inputDto.getDate(),
                warehouseRepository.findById(inputDto.getWarehouseId()).get(),
                supplierRepository.findById(inputDto.getSupplierId()).get(),
                currencyRepository.findById(inputDto.getCurrencyId()).get(),
                inputDto.getFactureNumber(),
                inputDto.getCode()
        ));
        return new Result("Saved",true,savedInput);
    }

    public Result getAllInput() {
        return new Result("All Input",true,inputRepository.findAll());
    }

    public Result getInputById(Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
//        return optionalInput.isPresent()?new Result("input by id",true,optionalInput.get():new Result("not found",false));
        return optionalInput.map(input -> new Result("input by id", true, input)).orElseGet(() -> new Result("not found", false));
    }

    public Result editInput(Integer id, InputDto inputDto) {
        return null;
    }
}
