package com.wujiabo.fsd.feign;

import com.wujiabo.fsd.dto.TUser;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeign {
    @Override
    public TUser findByEmail(String email) {
        return null;
    }

    @Override
    public void save(TUser registerUser) {

    }
}
