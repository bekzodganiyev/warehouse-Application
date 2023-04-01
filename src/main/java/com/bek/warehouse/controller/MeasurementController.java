package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Measurement;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    // Add measurement
    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement) {
        return measurementService.addMeasurement(measurement);
    }

    // Get all measurements
    @GetMapping
    public Result getAllMeasurement() {
        return measurementService.getAllMeasurement();
    }

    // Get one measurement
    @GetMapping("/{id}")
    public Result getMeasurementById(@PathVariable Integer id) {
        return measurementService.getMeasurementById(id);
    }

    // Edit measurement
    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement) {
        return measurementService.editMeasurement(id,measurement);
    }

    // Delete measurement
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        return measurementService.deleteMeasurement(id);
    }

}
