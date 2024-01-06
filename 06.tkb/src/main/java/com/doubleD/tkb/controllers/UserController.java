package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.ResponseObject;
import com.doubleD.tkb.models.User;
import com.doubleD.tkb.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("api/v2/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    //Get all User
    // http://localhost:8088/api/v2/user/getAllUser
    @GetMapping("/getAllUser")
    List<User> getAllUser(){
        return userServiceImpl.getAllUsers();
    }

    //Insert User
    @PutMapping("/insert")
    ResponseEntity<ResponseObject> insertUser(
           @Valid @RequestBody User user,
           BindingResult result
    ){
        if (result.hasFieldErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(
                            "OK",
                            "Insert thành công",
                            errorMessages
                    ));
        }
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        User newUser = new User();
        try {
            newUser = userServiceImpl.insertUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(
                            "OK",
                            "Insert thành công",
                            newUser
                    )
            );

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(
                            "OK",
                            "Insert thành công",
                            e.getMessage()
                    ));
        }
    }

    // Get User by phone
    // http://localhost:8088/api/v2/user/GetUserByPhoneNumber/0980000000
    @GetMapping("/GetUserByPhoneNumber/{phoneNumber}")
    ResponseEntity<ResponseObject> getUserByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject(
                    "OK",
                    "Lấy thông tin user thành công",
                    userServiceImpl.getUserByPhoneNumber(phoneNumber)
            ));
    }
}
