package com.wujiabo.fsd.service;

import com.wujiabo.fsd.entity.TUser;

import java.util.List;

public interface UserService {
    List<TUser> findAll();

    TUser findByEmail(String email);

    void save(TUser tUser);
}
