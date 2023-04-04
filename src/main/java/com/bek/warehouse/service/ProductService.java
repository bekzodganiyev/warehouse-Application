package com.bek.warehouse.service;

import com.bek.warehouse.entity.Attachment;
import com.bek.warehouse.entity.Category;
import com.bek.warehouse.entity.Measurement;
import com.bek.warehouse.entity.Product;
import com.bek.warehouse.payload.ProductDto;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.AttachmentRepository;
import com.bek.warehouse.repository.CategoryRepository;
import com.bek.warehouse.repository.MeasurementRepository;
import com.bek.warehouse.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ProductService {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final AttachmentRepository attachmentRepository;
    final MeasurementRepository measurementRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, AttachmentRepository attachmentRepository, MeasurementRepository measurementRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.attachmentRepository = attachmentRepository;
        this.measurementRepository = measurementRepository;
    }

    public Result addProduct(ProductDto productDto) {
        if (productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId())) {
            return new Result("This product is already exist.", false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new Result("Category not found", false);
        }
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getAttachmentId());
        if (optionalAttachment.isEmpty()) {
            return new Result("Attachment not found", false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (optionalMeasurement.isEmpty()) {
            return new Result("Measurement not found", true);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");// TODO: 04-Apr-23 must generate code
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        Product savedProduct = productRepository.save(product);
        return new Result("Product is saved", true, savedProduct);
    }
}
