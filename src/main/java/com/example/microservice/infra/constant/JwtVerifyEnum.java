package com.example.microservice.infra.constant;

import cn.hutool.core.util.StrUtil;

/**
 * @Author 钟玖林
 * @Date 2020/12/16 21:54
 * @Version 1.0
 */
public enum JwtVerifyEnum {
    /**
     * 枚举jwt验证结果常量
     */
    SUCCESS("success", "token验证成功"),
    EXPIRED("expired", "token已过期"),
    SIGNATURE_VERIFICATION("signature_verification", "token签名失败"),
    DECODE_ERROR("decode_error", "token解析失败，请重新登录获取token"),
    NOT_LOGIN("not_login", "未登录")
    ;

    private String code;
    private String message;

    JwtVerifyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public static String getValueByCode(String code){
        for(JwtVerifyEnum batchChangeEnum : JwtVerifyEnum.values()){
            if(StrUtil.equals(code, batchChangeEnum.getCode())){
                return batchChangeEnum.getMessage();
            }
        }
        return "";
    }
}
