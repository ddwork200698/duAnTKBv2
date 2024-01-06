package com.doubleD.tkb.services.impl;

import com.doubleD.tkb.models.Role;
import com.doubleD.tkb.repos.RoleRepo;
import com.doubleD.tkb.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
   @Autowired
    RoleRepo roleRepo;
    @Override
    public List<Role> getAllRole() {
        return roleRepo.findAll();
    }
}
