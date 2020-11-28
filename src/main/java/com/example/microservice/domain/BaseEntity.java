package com.example.microservice.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author 钟玖林10265666
 * @version 1.0
 * @date 2020/11/28 17:05
 */
@Data
public class BaseEntity {
    /**
     * 创建人
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    protected String createdBy;

    /**
     * 创建时间，创建时采用数据默认值，不进行自动填充
     */
    protected Date creationDate;

    /**
     * 最后修改人
     */
    @TableField(value = "last_updated_by", fill = FieldFill.INSERT_UPDATE)
    protected String lastUpdatedBy;

    /**
     * 最后更新时间，创建时采用数据默认值，不进行自动填充
     */
    @TableField(value = "last_update_date", fill = FieldFill.UPDATE, update = "now()")
    protected Date lastUpdateDate;

    /**
     * 有效性(Y/N)，该字段必须放最后，不然逻辑删除不起作用
     */
    @TableField(value = "enabled_flag", fill = FieldFill.INSERT)
    @TableLogic(value = "Y", delval = "N")
    protected String enabledFlag;
}
