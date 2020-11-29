package com.ly.shiro.service.impl;

import com.ly.shiro.entity.User;
import com.ly.shiro.mapper.UserMapper;
import com.ly.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByName(String name) {
        return userMapper.selectUserByName(name);
    }
}
