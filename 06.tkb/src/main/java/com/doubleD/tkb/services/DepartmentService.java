package com.doubleD.tkb.services;

import com.doubleD.tkb.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartment();
}
