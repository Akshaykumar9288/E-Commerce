package com.E_commerce.App.Service;

import com.E_commerce.App.Repository.ProductRepository;
import com.E_commerce.App.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product create(Product product){
        return repository.save(product);
    }

    public List<Product> getProduct(){
        return repository.findAll();
    }

    public List<Product> getProductByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> getProductByName(String productName){
        return repository.findByName(productName);
    }

    public List<Product> getProductByBrand(String productBrand){
        return repository.findByBrand(productBrand);
    }

    public List<Product> getProductByPrice(int productPrice){
        return repository.findByPrice(productPrice);
    }

}
