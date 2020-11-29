package com.example.microservice.app.dto;

import com.example.microservice.domain.User;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:33
 * @Version 1.0
 */

@Data
public class UserDTO {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("年龄")
    @Min(0)
    @Max(100)
    private Integer age;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("城市id")
    private String cityid;

    public static List<UserDTO> build(List<User> users) {
        // 转换为DTO返回
        List<UserDTO> userDTOs = new ArrayList<>();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        users.forEach(user -> {
            UserDTO userDto = mapper.map(user, UserDTO.class);
            userDTOs.add(userDto);
        });
        return userDTOs;
    }

    public static UserDTO build(User user) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper.map(user, UserDTO.class);
    }
}
