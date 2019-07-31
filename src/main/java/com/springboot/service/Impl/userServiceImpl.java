package com.springboot.service.Impl;

import com.springboot.mapper.UserMapper;
import com.springboot.model.User;
import com.springboot.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class userServiceImpl implements userService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public User getUserInfo(String id) {
        return userMapper.getUserInfo(id);
    }
}
