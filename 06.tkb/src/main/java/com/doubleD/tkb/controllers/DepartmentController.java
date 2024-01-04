package com.doubleD.tkb.controllers;

import com.doubleD.tkb.models.ResponseObject;
import com.doubleD.tkb.services.impl.DepartmentServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceIplm departmentServiceIplm;

    //Get all Department
    // http://localhost:8088/api/v2/department
    @GetMapping("/all")
    ResponseEntity<ResponseObject> getAllDepartment(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "OK",
                        "Lấy tất cả thông tin department thành công",
                        departmentServiceIplm.getAllDepartment()
                )
        );
    };
}
