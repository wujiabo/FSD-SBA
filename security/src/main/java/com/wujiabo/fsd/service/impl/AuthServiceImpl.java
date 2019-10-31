package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.TUser;
import com.wujiabo.fsd.feign.UserFeign;
import com.wujiabo.fsd.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserFeign userFeign;
    @Override
    public void register(TUser registerUser) {
        registerUser.setPwd(bCryptPasswordEncoder.encode(registerUser.getPwd()));
        userFeign.save(registerUser);
    }
}
