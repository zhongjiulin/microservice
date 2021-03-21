package com.example.microservice.app.dto;

import com.example.microservice.domain.UmsAdmin;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:33
 * @Version 1.0
 */

@Data
public class UmsAdminDTO {
    @ApiModelProperty("id")
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @ApiModelProperty("头像")
    private String icon;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    private String note;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

    public static List<UmsAdminDTO> build(List<UmsAdmin> umsAdmins) {
        // 转换为DTO返回
        List<UmsAdminDTO> userDTOs = new ArrayList<>();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        umsAdmins.forEach(umsAdmin -> {
            UmsAdminDTO umsAdminDTO = mapper.map(umsAdmin, UmsAdminDTO.class);
            userDTOs.add(umsAdminDTO);
        });
        return userDTOs;
    }

    public static UmsAdminDTO build(UmsAdmin umsAdmin) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        if (umsAdmin != null) {
            return mapper.map(umsAdmin, UmsAdminDTO.class);
        }
        return new UmsAdminDTO();
    }
}
