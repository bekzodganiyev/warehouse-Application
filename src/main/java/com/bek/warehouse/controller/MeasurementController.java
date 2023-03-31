package com.bek.warehouse.controller;

import com.bek.warehouse.entity.Measurement;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement) {
        return new Result();
    }

    // TODO: 31-Mar-23 Get List, Get one, Edit, Delete

}
