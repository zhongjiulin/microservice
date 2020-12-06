package com.example.microservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UmsAdmin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

    public static UmsAdmin build(UmsAdminDTO umsAdminDTO) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        if (umsAdminDTO != null) {
            return mapper.map(umsAdminDTO, UmsAdmin.class);
        }
        return new UmsAdmin();
    }
}
