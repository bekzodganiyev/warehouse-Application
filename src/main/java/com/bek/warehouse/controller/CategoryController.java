package com.bek.warehouse.controller;

import com.bek.warehouse.payload.CategoryDto;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping
    public Result getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Result getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return categoryService.editCategory(id,categoryDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }



}
