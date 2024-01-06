package com.doubleD.tkb.repos;

import com.doubleD.tkb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    List<Role> findAll();
}
