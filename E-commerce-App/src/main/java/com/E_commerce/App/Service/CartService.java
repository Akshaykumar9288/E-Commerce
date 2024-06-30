package com.E_commerce.App.Service;

import com.E_commerce.App.Repository.CartItemRepository;
import com.E_commerce.App.Repository.ProductRepository;
import com.E_commerce.App.Repository.UserRepository;
import com.E_commerce.App.model.CartItem;
import com.E_commerce.App.model.Product;
import com.E_commerce.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    public String addToCart(Long userId, Long productId, int quantity){

        User user = userRepository.findById(userId);
        Product product = productRepository.findById(productId);

        Optional<CartItem> existingCartItem = cartItemRepository.findByUserAndProduct(user, product);
        if (product.getQuantity() == 0){
            return "Product quantity is zero and cannot be added to the cart.";
        }
        if (product.getQuantity() < quantity){
            return "Out Of Quantity";
        }
        CartItem cartItem;
        if (existingCartItem.isPresent()) {
            cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
        }
        cartItemRepository.save(cartItem);
        return "Product Added To Cart Successfully";
    }
}
