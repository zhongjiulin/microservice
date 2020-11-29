package com.example.microservice.infra.config;

import com.example.microservice.infra.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 11:21
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    /**
     * 切入点  即 aop 切入的路径（被拦截的方法）
     */
    @Pointcut("execution(public * com.example.microservice.*.controller..*.*(..))")
    public void aspectPoint() {
    }

    /**
     * 前置通知
     */
    @Before("aspectPoint()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        // 执行controller 方法之前需要记录的请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL: {}",request.getRequestURL());
        log.info("HTTP_METHOD: {} ", request.getMethod());
        log.info("IP: {}", request.getRemoteAddr());
        log.info("CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS: {}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置通知
     */
    @AfterReturning(returning = "apiResult", pointcut = "aspectPoint()")
    public void logResultVOInfo(ApiResult apiResult) throws Exception {
        log.info("请求结果：" + apiResult.getStatus() + "\t" + apiResult.getMsg());
    }
}
