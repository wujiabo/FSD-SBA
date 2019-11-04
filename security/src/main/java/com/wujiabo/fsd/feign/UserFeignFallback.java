package com.wujiabo.fsd.feign;

import com.wujiabo.fsd.dto.TUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeign {
    @Override
    public ResponseEntity<TUser> findByEmail(String email) {
        return null;
    }

    @Override
    public ResponseEntity<Void> save(TUser registerUser) {
        return null;
    }
}
