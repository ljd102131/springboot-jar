package com.springboot;

import com.springboot.dbconfig.DBConfig1;
import com.springboot.dbconfig.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.springboot.data1.mapper","com.springboot.data2.mapper","com.springboot.mapper"})//注意：@MapperScan配置成com.springboot.*，会出现以下异常：
//org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.springboot.service.userServiceData1.getUserList
@ComponentScan(basePackages = {"com.springboot.*","com.springboot.*.*","com.springboot.*.*.*"})//组件扫描，配置扫描的包
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //启动springboot项目
        SpringApplication.run(App.class,args);
        System.out.println( "success..." );
    }
}
