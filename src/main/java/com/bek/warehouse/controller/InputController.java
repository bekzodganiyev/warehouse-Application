package com.bek.warehouse.controller;

import com.bek.warehouse.payload.InputDto;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;

    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        return inputService.addInput(inputDto);
    }

    @GetMapping
    public Result getAllInput(){
        return inputService.getAllInput();
    }

    @GetMapping("/{id}")
    public Result getInputById(@PathVariable Integer id){
        return inputService.getInputById(id);
    }

    @PutMapping("/{id}")
    public Result editInput(@PathVariable Integer id,@RequestBody InputDto inputDto){
        return inputService.editInput(id,inputDto);
    }
}
