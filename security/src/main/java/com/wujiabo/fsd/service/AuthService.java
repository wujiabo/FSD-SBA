package com.wujiabo.fsd.service;

import com.wujiabo.fsd.dto.TUser;
import com.wujiabo.fsd.dto.UserInfoDto;

public interface AuthService {
    void register(TUser registerUser);

    UserInfoDto checkToken(String token);
}
