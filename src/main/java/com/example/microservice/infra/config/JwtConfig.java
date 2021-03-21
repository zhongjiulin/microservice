package com.example.microservice.infra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 钟玖林
 * @Date 2020/12/9 21:28
 * @Version 1.0
 * JWT相关属性配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private long expire;
    private String secret;
}
