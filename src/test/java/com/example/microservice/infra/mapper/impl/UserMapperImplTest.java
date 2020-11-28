package com.example.microservice.infra.mapper.impl;


import com.example.microservice.BaseTest;
import com.example.microservice.domain.User;
import com.example.microservice.infra.mapper.IUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class UserMapperImplTest extends BaseTest {
    @Autowired
    private IUserMapper userMapper;

    @Test
    public void contextLoads() {
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        Collection<User> users = userMapper.listByIds(ids);
        log.info("查询结果：{}", users.toString());
    }
}