package com.doubleD.tkb.services.impl;

import com.doubleD.tkb.models.Department;
import com.doubleD.tkb.repos.DepartmentRepo;
import com.doubleD.tkb.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceIplm implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }
}
