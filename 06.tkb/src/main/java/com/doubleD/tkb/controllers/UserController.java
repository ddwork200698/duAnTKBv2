package com.doubleD.tkb.controllers;

import com.doubleD.tkb.services.impl.UserServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/")
public class UserController {
    @Autowired
    UserServiceIplm userServiceIplm;
}
