package com.example.microservice.app.service;

import com.example.microservice.app.dto.UserDTO;
import com.example.microservice.domain.User;

import java.util.List;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:00
 * @Version 1.0
 */
public interface IUserService {
    /**
     * 获取所有用户
     * @return
     */
    List<UserDTO> getAll();

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UserDTO getOne(Long id);

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    User insert(UserDTO userDTO);
}
