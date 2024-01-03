package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.User;
import com.doubleD.tkb.services.impl.UserServiceIplm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v2")
@Validated
public class UserController {
    @Autowired
    UserServiceIplm userServiceIplm;

    //Get all User
    // http://localhost:8088/api/v2/getAllUser
    @GetMapping("/getAllUser")
    List<User> getAllUser(){
        return userServiceIplm.getAllUsers();
    }

    //Insert User
    @PutMapping("/insert")
    User insertUser(
           @Valid @RequestBody User user
    ){
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());
        return userServiceIplm.insertUser(user);
    }
}
