package com.E_commerce.App.Repository;

import com.E_commerce.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByUsername(@Param("email") String email);
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findById(@Param("id") Long id);
}
