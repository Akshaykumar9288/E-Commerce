package com.E_commerce.App.controller;


import com.E_commerce.App.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam  Long userId, @RequestParam Long productId, @RequestParam int quantity){
        String msg = cartService.addToCart(userId,productId,quantity);
        return ResponseEntity.ok(msg);
    }
}
