package com.doubleD.tkb.repos;

import com.doubleD.tkb.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, String> {
    List<Department> findAll();
    Department getById(String id);
}
