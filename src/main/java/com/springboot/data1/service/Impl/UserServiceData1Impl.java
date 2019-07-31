package com.springboot.data1.service.Impl;

import com.springboot.data1.service.userServiceData1;
import com.springboot.data1.mapper.UserData1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceData1Impl implements userServiceData1 {

    @Resource
    public UserData1Mapper userData1Mapper;

    @Override
    public List<Map<String,Object>> getTopicListData1(){
        return userData1Mapper.getTopicListData1();
    }
}
