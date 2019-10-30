package com.wujiabo.fsd.service;

import com.wujiabo.fsd.dto.JwtUser;

public interface TokenService {
    String generate(JwtUser jwtUser);
}
