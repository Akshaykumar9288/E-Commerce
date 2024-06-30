package com.E_commerce.App.Repository;

import com.E_commerce.App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT u FROM Product u WHERE u.productCategory = :productCategory")
    List<Product> findByCategory(@Param("productCategory") String productCategory);

    @Query("SELECT u FROM Product u WHERE u.productName = :productName")
    List<Product> findByName(@Param("productName") String productName);

    @Query("SELECT u FROM Product u WHERE u.productBrand = :productBrand")
    List<Product> findByBrand(@Param("productBrand") String productBrand);

    @Query("SELECT u FROM Product u WHERE u.productPrice <= :productPrice")
    List<Product> findByPrice(@Param("productPrice") int productPrice);

    @Query("SELECT u FROM Product u WHERE u.id = :id")
    Product findById(@Param("id")Long id);
}
