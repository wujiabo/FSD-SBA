package com.wujiabo.fsd.controller;

import com.wujiabo.fsd.entity.TUser;
import com.wujiabo.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<TUser> list(){
        return userService.findAll();
    }

    @GetMapping("/findByEmail/{email}")
    public TUser findByEmail(@PathVariable(name = "email", required=true) String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/save")
    public void save(@RequestBody TUser tUser){
        userService.save(tUser);
    }
}
