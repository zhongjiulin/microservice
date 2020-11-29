package com.example.microservice.infra.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Supplier;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 11:53
 * @Version 1.0
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATED_BY = "createdBy";
    private static final String UPDATED_BY = "lastUpdatedBy";
    private static final String CREATED_DATE = "creationDate";
    private static final String UPDATED_DATE = "lastUpdateDate";
    private static final String ENABLED_FLAG = "enabledFlag";

    /**
     * 插入公共字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String operator = "钟玖林";
        fillValue(metaObject, CREATED_BY, () -> operator);
        fillValue(metaObject, UPDATED_BY, () -> operator);
///        fillValue(metaObject, CREATED_DATE, () -> getDateValue(metaObject.getSetterType(CREATED_DATE)));
///        fillValue(metaObject, UPDATED_DATE, () -> getDateValue(metaObject.getSetterType(UPDATED_DATE)));
        fillValue(metaObject, ENABLED_FLAG, () -> "Y");
    }

    /**
     * 更新公共字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String operator = "钟玖林";
        fillValue(metaObject, "et." + UPDATED_BY, () -> operator);
        fillValue(metaObject, "et." + UPDATED_DATE, () -> getDateValue(metaObject.getSetterType("et." + UPDATED_DATE)));
    }

    private void fillValue(MetaObject metaObject, String fieldName, Supplier<Object> valueSupplier) {
        if (!metaObject.hasGetter(fieldName)) {
            return;
        }
        Object sidObj = metaObject.getValue(fieldName);
        if (sidObj == null && metaObject.hasSetter(fieldName) && valueSupplier != null) {
            setFieldValByName(fieldName, valueSupplier.get(), metaObject);
        }
    }

    private Object getDateValue(Class<?> setterType) {
        if (Date.class.equals(setterType)) {
            return new Date();
        } else if (LocalDateTime.class.equals(setterType)) {
            return LocalDateTime.now();
        }
        return null;
    }
}
