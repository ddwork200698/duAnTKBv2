package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.DTO.UserDTO;
import com.doubleD.shopapp.DTO.UserLoginDTO;
import com.doubleD.shopapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
//@Validated
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    ResponseEntity<?> createUser(
            @Valid @RequestBody UserDTO userDTO,
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
            userService.createuser(userDTO);
            return ResponseEntity.ok().body("Success create user");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @PostMapping("/login")
    ResponseEntity<String> login(
            @Valid @RequestBody UserLoginDTO user
    ){
        return ResponseEntity.ok().body("some tokens");
    }
}
