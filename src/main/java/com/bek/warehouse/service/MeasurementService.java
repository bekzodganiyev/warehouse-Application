package com.bek.warehouse.service;

import com.bek.warehouse.entity.Measurement;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurement(Measurement measurement){
        if (measurementRepository.existsByName(measurement.getName())) {
            return new Result();
        }
        return new Result();
    }

}
