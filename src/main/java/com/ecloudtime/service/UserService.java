package com.ecloudtime.service;

import com.ecloudtime.mapper.UserMapper;
import com.ecloudtime.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        return user;
    }

}
