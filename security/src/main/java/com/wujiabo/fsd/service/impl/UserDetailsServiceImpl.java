package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.JwtUser;
import com.wujiabo.fsd.dto.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setId("1");
        user.setPassword("$2a$10$r.flqvEINoIUIFjFe1RfPuEzvYGrumS6jdhdt39AcYy4YjBZlgbD2");
        user.setUsername("3");
        user.setRole("4");
        return new JwtUser(user);
    }

}
