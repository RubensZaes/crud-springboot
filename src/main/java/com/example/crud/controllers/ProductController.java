package com.example.crud.controllers;

import com.example.crud.dtos.RequestProductDTO;
import com.example.crud.model.Product;
import com.example.crud.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO requestProductDTO){
        Product product = new Product(requestProductDTO);
        productRepository.save(product);
        return getAllProducts();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO requestProductDTO){
        Product product = productRepository.getReferenceById(requestProductDTO.id());
        product.setName(requestProductDTO.name());
        product.setPrice_in_cents(requestProductDTO.price_in_cents());
//        return new ResponseEntity<>(product, HttpStatus.OK);
        return getAllProducts();
    }
}
