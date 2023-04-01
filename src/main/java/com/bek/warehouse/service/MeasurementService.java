package com.bek.warehouse.service;

import com.bek.warehouse.entity.Measurement;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurement(Measurement measurement){
        if (measurementRepository.existsByName(measurement.getName())) {
            return new Result("This measurement is already exist. SORRY !!!",false);
        }
        Measurement savedMeasurement = measurementRepository.save(measurement);
        return new Result("SUCCESSFULLY SAVED !!!",true , savedMeasurement);
    }

    public Result getAllMeasurement() {
        return new Result("All measurement",true,measurementRepository.findAll());
    }

    public Result getMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
//        return optionalMeasurement.isPresent()?new Result("OK",true,optionalMeasurement.get()):new Result("Not found",false);
        return optionalMeasurement.map(measurement -> new Result("OK", true, measurement)).orElseGet(() -> new Result("Not found", false));
    }


    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            Measurement editingMeasurement = optionalMeasurement.get();
            editingMeasurement.setName(measurement.getName());
            Measurement savedMeasurement = measurementRepository.save(editingMeasurement);
            return new Result("Edited !!!",true, savedMeasurement);
        }
        return new Result("Not found",false);
    }

    public Result deleteMeasurement(Integer id) {
        if (measurementRepository.existsById(id)) {
            measurementRepository.deleteById(id);
            return new Result("Deleted !!!",true);
        }
        return new Result("This measurement is not exist !!!",false);
    }
}
