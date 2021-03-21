package com.example.microservice.infra.constant;

/**
 * @Author 钟玖林
 * @Date 2020/12/16 22:54
 * @Version 1.0
 */
public enum HttpStatusEnum {
    /**
     * 错误状态码
     */
    C200("200", "ok"),
    C403("403", "用户名或密码错误"),
    C500("500", "服务器异常")
    ;

    private String code;
    private String message;

    HttpStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
