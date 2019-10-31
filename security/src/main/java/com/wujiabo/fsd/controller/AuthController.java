package com.wujiabo.fsd.controller;

import com.wujiabo.fsd.dto.TUser;
import com.wujiabo.fsd.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public void register(@RequestBody TUser registerUser) {
        authService.register(registerUser);
    }
}
