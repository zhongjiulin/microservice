package com.example.microservice.infra.utils;

import com.example.microservice.infra.constant.HttpStatusEnum;
import lombok.Data;

/**
 * @Author 钟玖林
 * @Date 2020/12/16 22:52
 * @Version 1.0
 */
@Data
public class CustomerException extends RuntimeException {
    private String code;
    private String message;
    private String descInfo;

    public CustomerException(String descInfo) {
        this.code = HttpStatusEnum.C500.getCode();
        this.message = HttpStatusEnum.C500.getMessage();
        this.descInfo = descInfo;
    }
}
