package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.ResponseObject;
import com.doubleD.tkb.repos.ObjectRepo;
import com.doubleD.tkb.services.impl.ObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/object")
public class ObjectController {
    @Autowired
    ObjectServiceImpl objectServiceImpl;
    @GetMapping("")
    ResponseEntity<ResponseObject> getAllRole(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "OK",
                        "Lấy thành công All Data",
                        objectServiceImpl.getAllObject()
                )
        );
    }
}
