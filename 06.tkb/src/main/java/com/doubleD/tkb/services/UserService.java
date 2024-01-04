package com.doubleD.tkb.services;

import com.doubleD.tkb.models.User;
import com.doubleD.tkb.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User insertUser(User user);
    User getUserByPhoneNumber(String phoneNumber);
}
