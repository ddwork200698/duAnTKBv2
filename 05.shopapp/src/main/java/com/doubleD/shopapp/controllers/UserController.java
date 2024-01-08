package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.models.User;
import com.doubleD.shopapp.models.UserLogin;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
//@Validated
public class UserController {
    @PostMapping("/register")
    ResponseEntity<?> createUser(
            @Valid @RequestBody User user,
            BindingResult result
    ){
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok().body("Success create user");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @PostMapping("/login")
    ResponseEntity<String> login(
            @Valid @RequestBody UserLogin user
    ){
        return ResponseEntity.ok().body("some tokens");
    }
}
