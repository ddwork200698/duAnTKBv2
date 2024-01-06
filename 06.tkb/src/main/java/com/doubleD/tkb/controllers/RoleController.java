package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.ResponseObject;
import com.doubleD.tkb.models.User;
import com.doubleD.tkb.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleServiceImpl;

    //Get all Role
    // http://localhost:8088/api/v2/role
    @GetMapping("")
    ResponseEntity<ResponseObject> getAllRole(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "OK",
                        "Lấy thành công All Data",
                        roleServiceImpl.getAllRole()
                )
        );
    }
}
