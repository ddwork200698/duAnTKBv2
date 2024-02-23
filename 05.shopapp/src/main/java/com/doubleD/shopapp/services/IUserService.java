package com.doubleD.shopapp.services;

import com.doubleD.shopapp.DTO.UserDTO;
import com.doubleD.shopapp.Exceptions.DataNotFoundExcepsiton;
import com.doubleD.shopapp.models.User;

public interface IUserService {
    User createuser(UserDTO user) throws DataNotFoundExcepsiton;
    String login(String phoneNumber, String password);
}
