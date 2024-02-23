package com.doubleD.shopapp.repositories;

import com.doubleD.shopapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
