package com.doubleD.shopapp.services;

import com.doubleD.shopapp.DTO.UserDTO;
import com.doubleD.shopapp.Exceptions.DataNotFoundExcepsiton;
import com.doubleD.shopapp.models.Role;
import com.doubleD.shopapp.models.User;
import com.doubleD.shopapp.repositories.RoleRepo;
import com.doubleD.shopapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Override
    public User createuser(UserDTO user) throws DataNotFoundExcepsiton{
        String phoneNumber = user.getPhoneNumber();
        // KT sđt đã tồn tại chưa ?
        if(userRepo.existsByPhoneNumber(phoneNumber)){
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        // Convert from userDTO to user
        User newUser = User.builder()
                .fullname(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .address(user.getAddress())
                .dateOfBirth(user.getDateOfBirth())
                .facebookAccountId(user.getFacebookAccountId())
                .googleAccountId(user.getGoogleAccountId())
                .build();
        Role role = roleRepo.findById(user.getRoleId()).orElseThrow(()-> new DataNotFoundExcepsiton("Role not found"));
        newUser.setRole(role);
        // KT neu co accountId thi ko yeu cau mat khau
        if(user.getFacebookAccountId() == 0 && user.getGoogleAccountId() ==0){
            String password = user.getPassword();
            //String encodePassword = passwordEncoder.encode(password);
            //newUser.setPassword(encodePassword);
        }
        return userRepo.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }
}
