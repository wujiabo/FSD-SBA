package com.wujiabo.fsd.feign;

import com.wujiabo.fsd.dto.TUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sba-user", fallback = UserFeignFallback.class)
public interface UserFeign {

    @RequestMapping(value = "/api/user/findByEmail/{email}", method = RequestMethod.GET)
    TUser findByEmail(@PathVariable(name = "email", required=true) String email);

    @RequestMapping(value = "/api/user/save", method = RequestMethod.POST)
    void save(TUser registerUser);
}
