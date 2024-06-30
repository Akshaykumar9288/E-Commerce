package com.E_commerce.App.Repository;

import com.E_commerce.App.model.CartItem;
import com.E_commerce.App.model.Product;
import com.E_commerce.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByUser(User user);
    Optional<CartItem> findByUserAndProduct(User user, Product product);
}
