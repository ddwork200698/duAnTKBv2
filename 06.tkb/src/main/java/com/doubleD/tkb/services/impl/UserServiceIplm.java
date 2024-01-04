package com.doubleD.tkb.services.impl;

import com.doubleD.tkb.models.User;
import com.doubleD.tkb.repos.UserRepo;
import com.doubleD.tkb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIplm implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User insertUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepo.findByPhoneNumber(phoneNumber);
    }
}
