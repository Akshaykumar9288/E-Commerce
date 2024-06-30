package com.E_commerce.App.Service;


import com.E_commerce.App.Repository.UserRepository;
import com.E_commerce.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public User Registration(User user){
      return   repository.save(user);
    }

    public User login(String username,String password){
        User user1 = repository.findByUsername(username);
        if (user1 != null && user1.getPassword().equals(password)){
            return user1;
        }
        return null;
    }
}
