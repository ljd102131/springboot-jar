package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.userService;
import com.springboot.data1.service.userServiceData1;
import com.springboot.data2.service.userServiceData2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private userService userService;
    @Autowired
    private userServiceData1 userServiceData1;
    @Autowired
    private userServiceData2 userServiceData2;

    @RequestMapping("getUserInfo")
    public User getUserInfo(){
        User userInfo = userService.getUserInfo("123");
        return userInfo;
    }

    @RequestMapping("getUserList")
    public List<User> getUserList(){
        User user = new User();
        List<User> list = userService.getUserList(user);
        return list;
    }

    @RequestMapping("getTopicList")
    public List<Map<String,Object>> getTopicList(){
        List<Map<String,Object>> list1 = userServiceData1.getTopicListData1();
        List<Map<String,Object>> list2 = userServiceData2.getTopicListData2();
        return list1;
    }
}
