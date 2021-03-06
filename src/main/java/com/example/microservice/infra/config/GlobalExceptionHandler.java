package com.example.microservice.infra.config;


import com.example.microservice.infra.constant.HttpStatusEnum;
import com.example.microservice.infra.utils.ApiResult;
import com.example.microservice.infra.utils.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理 Handler
 * @ControllerAdvice  配置控制器通知
 * annotations 属性: 指定我们需要拦截的注解,一个或多个(多个加到大括号中,逗号分隔)
 */

/**
 * @Author 钟玖林
 * @Date 2020/11/29 9:44
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 默认统一异常处理方法
     * @ExceptionHandler 注解用来配置需要拦截的异常类型, 也可以是自定义异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult<String> runtimeExceptionHandler(Exception e) {
        ApiResult<String> apiResult = new ApiResult();
        // 打印异常信息到控制台
        e.printStackTrace();
        log.error("请求出现异常,异常信息为: {}", e.getMessage());
        // 使用公共的结果类封装返回结果, 这里我指定状态码为 500
        return apiResult.error(HttpStatusEnum.C500.getCode(), e.getMessage());
    }

    @ExceptionHandler(CustomerException.class)
    public ApiResult<String> customerExceptionHandler(CustomerException e) {
        ApiResult<String> apiResult = new ApiResult();
        // 打印异常信息到控制台
        e.printStackTrace();
        log.error("请求出现异常,异常信息为: {}", e.getMessage());
        // 使用公共的结果类封装返回结果, 这里我指定状态码为 500
        return apiResult.error(HttpStatusEnum.C500.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<String> handleBindException(MethodArgumentNotValidException ex) {
        ApiResult<String> apiResult = new ApiResult();
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return apiResult.error(HttpStatusEnum.C500.getCode(), fieldError.getDefaultMessage());
    }

    /**
     * 参数绑定异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ApiResult<String> handleBindException(BindException ex) {
        ApiResult<String> apiResult = new ApiResult();
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return apiResult.error(HttpStatusEnum.C500.getCode(), fieldError.getDefaultMessage());
    }
}
