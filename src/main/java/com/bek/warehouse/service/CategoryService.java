package com.bek.warehouse.service;

import com.bek.warehouse.entity.Category;
import com.bek.warehouse.payload.CategoryDto;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        if (categoryDto.getName() != null) {
            if (categoryDto.getParentCategoryId() == null) {
                category.setName(categoryDto.getName());
            }
            if (categoryRepository.existsById(categoryDto.getParentCategoryId())) {
                category.setName(categoryDto.getName());
                category.setParentCategory(categoryRepository.findById(categoryDto.getParentCategoryId()).get());
            }
            Category savedCategory = categoryRepository.save(category);
            return new Result("Saved !!!", true, savedCategory);
        }
        return new Result("Not save , category name is empty", false);
    }

    public Result getAllCategory() {
        return new Result("All category", true, categoryRepository.findAll());
    }

    public Result getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
//        return optionalCategory.isPresent()?new Result("OK",true,optionalCategory.get()):new Result("Not found",false);
        return optionalCategory.map(category -> new Result("OK", true, category)).orElseGet(() -> new Result("Not found", false));
    }

    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category editingCategory = optionalCategory.get();
            editingCategory.setName(categoryDto.getName());
            Category editedCategory = categoryRepository.save(editingCategory);
            return new Result("Edited !!!", true, editedCategory);
        }
        return new Result("Not Edited", false);
    }

    public Result deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return new Result("Deleted !!!", true);
        }
        return new Result("This category is not exist !!!", false);
    }
}
