package com.doubleD.tkb.services;

import com.doubleD.tkb.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRole();
}
