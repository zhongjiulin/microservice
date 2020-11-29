package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.User;
import com.example.microservice.infra.mapper.repository.UserRepository;
import com.example.microservice.infra.mapper.IUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 9:35
 * @Version 1.0
 */

@Service
public class UserMapperImpl extends ServiceImpl<UserRepository, User> implements IUserMapper {

}
