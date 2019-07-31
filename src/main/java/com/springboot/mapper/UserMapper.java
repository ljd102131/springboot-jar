package com.springboot.mapper;

import com.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList(User user);

    User getUserInfo(String id);
}
