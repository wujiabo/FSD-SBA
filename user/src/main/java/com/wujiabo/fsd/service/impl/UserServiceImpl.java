package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.entity.TUser;
import com.wujiabo.fsd.entity.TUserCriteria;
import com.wujiabo.fsd.mapper.TUserMapper;
import com.wujiabo.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper tUserMapper;
    @Override
    public List<TUser> findAll() {
        TUserCriteria example = new TUserCriteria();
        return tUserMapper.selectByExample(example);
    }
}
