package com.E_commerce.App.controller;

import com.E_commerce.App.Service.ProductService;
import com.E_commerce.App.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/CreateProduct")
    public Product create(@RequestBody Product product){
        Product product1 = service.create(product);
        if (product1!=null){
            ResponseEntity.status(200).body("Product Create");
            return service.create(product);
        }
        ResponseEntity.status(400).body("Product not Create");
        return null;
    }

    @GetMapping("/getAllProduct")
    public List<Product> getProduct(){
       return service.getProduct();
    }

    @GetMapping("/getProductByCategory/{productCategory}")
    public List<Product> getProductByCategory(@PathVariable String productCategory){
        return service.getProductByCategory(productCategory);
    }
    @GetMapping("/getProductByName/{productName}")
    public List<Product> getProductByName(@PathVariable String productName){
        return service.getProductByName(productName);
    }

    @GetMapping("/getProductByBrand/{productBrand}")
    public List<Product> getProductByBrand(@PathVariable String productBrand){
        return service.getProductByBrand(productBrand);
    }

    @GetMapping("/getProductByPrice/{productPrice}")
    public List<Product> getProductByPrice(@PathVariable int productPrice){
        return service.getProductByPrice(productPrice);

    }

}
