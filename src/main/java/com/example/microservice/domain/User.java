package com.example.microservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.example.microservice.domain.BaseEntity;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-11-28
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 描述
     */
    private String description;

    /**
     * 城市id
     */
    private String cityid;

}
