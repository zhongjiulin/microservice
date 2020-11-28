package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.User;
import com.example.microservice.infra.mapper.repository.UserRepository;
import com.example.microservice.infra.mapper.IUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-11-28
 */
@Service
public class UserMapperImpl extends ServiceImpl<UserRepository, User> implements IUserMapper {

}
