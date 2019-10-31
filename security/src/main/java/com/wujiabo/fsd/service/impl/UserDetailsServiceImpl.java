package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.JwtUser;
import com.wujiabo.fsd.dto.User;
import com.wujiabo.fsd.entity.TUser;
import com.wujiabo.fsd.entity.TUserCriteria;
import com.wujiabo.fsd.mapper.TUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUserCriteria example = new TUserCriteria();
        example.createCriteria().andUsernameEqualTo(username);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tUsers)){
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(tUsers.get(0),user);
        return new JwtUser(user);
    }

}
