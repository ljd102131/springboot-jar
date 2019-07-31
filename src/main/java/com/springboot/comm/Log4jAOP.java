package com.springboot.comm;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect//作用是把当前类标识为一个切面供容器读取
@Component
public class Log4jAOP {

    private Logger logger = Logger.getLogger(getClass());

    /**
     * execution函数用于匹配方法执行的连接点，语法为：
     * execution(方法修饰符(可选)  返回类型  方法名  参数  异常模式(可选))
     */
    @Pointcut("execution(public * com.springboot.controller..*.*(..))")//Pointcut表示式
    public void webLog() {

    }

    @Before("webLog()")//标识一个前置增强方法，相当于BeforeAdvice的功能
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("---------------request----------------");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:" + name + "value" + request.getParameter(name));
        }
    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")//后置增强，相当于AfterReturningAdvice，方法正常退出时执行
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("---------------response----------------");
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
