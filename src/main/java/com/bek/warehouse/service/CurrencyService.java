package com.bek.warehouse.service;

import com.bek.warehouse.entity.Currency;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency) {
        if (currencyRepository.existsByName(currency.getName())) {
            return new Result("This currency is already exist. SORRY !!!", false);
        }
        Currency savedCurrency = currencyRepository.save(currency);
        return new Result("SUCCESSFULLY SAVED !!!", true, savedCurrency);
    }

    public Result getAllCurrency() {
        return new Result("All currency", true, currencyRepository.findAll());
    }

    public Result getCurrencyById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
//        return optionalCurrency.isPresent()?new Result("OK",true,optionalMeasurement.get()):new Result("Not found",false);
        return optionalCurrency.map(currency -> new Result("OK", true, currency)).orElseGet(() -> new Result("Not found", false));
    }


    public Result editCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            Currency editingCurrency = optionalCurrency.get();
            editingCurrency.setName(currency.getName());
            Currency savedCurrency = currencyRepository.save(editingCurrency);
            return new Result("Edited !!!", true, savedCurrency);
        }
        return new Result("Not found", false);
    }

    public Result deleteCurrency(Integer id) {
        if (currencyRepository.existsById(id)) {
            currencyRepository.deleteById(id);
            return new Result("Deleted !!!", true);
        }
        return new Result("This measurement is not exist !!!", false);
    }
}
