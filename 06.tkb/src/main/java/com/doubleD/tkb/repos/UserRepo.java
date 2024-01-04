package com.doubleD.tkb.repos;

import com.doubleD.tkb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();
    User findByPhoneNumber(String phoneNumber);
}
