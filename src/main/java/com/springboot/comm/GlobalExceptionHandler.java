package com.springboot.comm;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice//控制器切面
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> exMap = new HashMap<>();
        exMap.put("reason",e.toString());
        exMap.put("status","500");
        exMap.put("msg","糟糕，系统出现错误！");
        System.out.println(e.toString());
        return exMap;
    }
}
