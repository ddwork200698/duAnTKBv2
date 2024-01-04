package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.ResponseObject;
import com.doubleD.tkb.models.User;
import com.doubleD.tkb.services.impl.UserServiceIplm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("api/v2")
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
    ResponseEntity<ResponseObject> insertUser(
           @Valid @RequestBody User user,
           BindingResult result
    ){
        if (result.hasFieldErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());
        User newUser = new User();
        try {
            newUser = userServiceIplm.insertUser(user);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(
                            "OK",
                            "Insert thành công",
                            "Ko inseart thành công do trùng"
                    ));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "OK",
                        "Insert thành công",
                        userServiceIplm.insertUser(user)
                )
        );
    }
}
