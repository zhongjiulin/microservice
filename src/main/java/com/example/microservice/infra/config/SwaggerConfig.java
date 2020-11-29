package com.example.microservice.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 9:53
 * @Version 1.0
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 设置项目名
                .groupName("微服务基础结构项目")
                .apiInfo(apiInfo())
                // 设置api根路径
                .pathMapping("/")
                // 初始化并返回一个API选择构造器
                .select()
                // swagger api扫描的路径
                .apis(RequestHandlerSelectors.basePackage("com.example.microservice.app.controller"))
                // 设置路径筛选
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微服务基础结构项目服务")
                .description("提供微服务接口")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }
}
