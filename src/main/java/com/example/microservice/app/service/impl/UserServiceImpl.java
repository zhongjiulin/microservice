package com.example.microservice.app.service.impl;

import com.example.microservice.app.dto.UserDTO;
import com.example.microservice.app.service.IUserService;
import com.example.microservice.domain.User;
import com.example.microservice.infra.mapper.IUserMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:01
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userMapper.list();

        return UserDTO.build(users);
    }

    @Override
    public UserDTO getOne(Long id) {
        User user = userMapper.getById(id);
        return UserDTO.build(user);
    }

    @Override
    public User insert(UserDTO userDTO) {
      User user = User.build(userDTO);
      userMapper.save(user);
      return user;
    }
}
