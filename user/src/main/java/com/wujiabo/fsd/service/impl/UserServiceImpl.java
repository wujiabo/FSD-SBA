package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.entity.TUser;
import com.wujiabo.fsd.entity.TUserCriteria;
import com.wujiabo.fsd.mapper.TUserMapper;
import com.wujiabo.fsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> findAll() {
        TUserCriteria example = new TUserCriteria();
        return tUserMapper.selectByExample(example);
    }

    @Override
    public TUser findByEmail(String email) {
        TUserCriteria example = new TUserCriteria();
        example.createCriteria().andEmailEqualTo(email);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUsers)) {
            return null;
        }
        return tUsers.get(0);
    }

    @Override
    public void save(TUser tUser) {
        if (tUser.getId() != null) {
            tUserMapper.updateByPrimaryKeySelective(tUser);
        } else {
            tUser.setId(UUID.randomUUID().toString());
            tUserMapper.insertSelective(tUser);
        }
    }
}
