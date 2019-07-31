package com.springboot.service;

import com.springboot.model.User;
import java.util.List;
import java.util.Map;

public interface userService {
    List<User> getUserList(User user);

    User getUserInfo(String id);
}
