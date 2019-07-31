package com.springboot.controller;

import com.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("getStudents/{name}")
    public String getStudents(ModelMap map, @PathVariable String name){
        map.put("name",name);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        map.put("time",hour);
        List<Student> list = new ArrayList<>();
        list.add(new Student().student("0001","zhangsan","男","07"));
        list.add(new Student().student("0002","lisi","男","08"));
        list.add(new Student().student("0003","wangwu","男","09"));
        map.put("list",list);
        return "views/student";
    }
}
