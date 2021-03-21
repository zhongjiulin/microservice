package com.example.microservice.infra.utils;

import com.example.microservice.infra.constant.HttpStatusEnum;
import lombok.Data;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 9:38
 * @Version 1.0
 */

@Data
public class ApiResult<T> {
    /**
     * 响应业务状态
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应中的数据
     */
    private T data;

    public ApiResult() {
    }

    private ApiResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private ApiResult(String code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public ApiResult<T> success(T data) {
        return new ApiResult<>(HttpStatusEnum.C200.getCode(), "ok", data);
    }

    public ApiResult<T> error(String code, String message) {
        return new ApiResult<>(code, message);
    }

    public ApiResult<T> build(String code, String message, T data) {
        return new ApiResult<>(code, message, data);
    }
}
