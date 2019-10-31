package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.TUser;
import com.wujiabo.fsd.dto.UserInfoDto;
import com.wujiabo.fsd.exception.TokenIsExpiredException;
import com.wujiabo.fsd.feign.UserFeign;
import com.wujiabo.fsd.service.AuthService;
import com.wujiabo.fsd.utils.JwtTokenUtils;
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

    @Override
    public UserInfoDto checkToken(String token) {
        token = token.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        if(JwtTokenUtils.isExpiration(token)){
            throw new TokenIsExpiredException("token超时了");
        }
        String username = JwtTokenUtils.getUsername(token);
        String role = JwtTokenUtils.getUserRole(token);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(username);
        userInfoDto.setRole(role);
        return userInfoDto;
    }
}
