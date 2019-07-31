package com.springboot.data2.service.Impl;

import com.springboot.data2.service.userServiceData2;
import com.springboot.data2.mapper.UserData2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceData2Impl implements userServiceData2 {

    @Resource
    public UserData2Mapper userData2Mapper;


    @Override
    public List<Map<String,Object>> getTopicListData2(){
        return userData2Mapper.getTopicListData2();
    }
}
