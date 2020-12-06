package com.example.microservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.example.microservice.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户登录日志表
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UmsAdminLoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    private String ip;

    private String address;

    /**
     * 浏览器登录类型
     */
    private String userAgent;


}
