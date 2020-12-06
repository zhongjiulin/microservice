package com.example.microservice.infra.mapper.impl;


import com.example.microservice.BaseTest;
import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.mapper.IUmsAdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @Author 钟玖林
 * @Date 2020/11/29 9:32
 * @Version 1.0
 */
@Slf4j
public class UserMapperImplTest extends BaseTest {
    @Autowired
    private IUmsAdminMapper umsAdminMapper;

    @Test
    public void contextLoads() {
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        Collection<UmsAdmin> users = umsAdminMapper.listByIds(ids);
        log.info("查询结果：{}", users.toString());
    }
}