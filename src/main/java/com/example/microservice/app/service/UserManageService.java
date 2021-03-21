package com.example.microservice.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.domain.UmsAdmin;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:00
 * @Version 1.0
 */
public interface UserManageService {
    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UmsAdminDTO getOne(Long id);

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    UmsAdmin insert(UmsAdminDTO userDTO);

    /**
     * 登录校验
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取所有用户
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<UmsAdminDTO> listUmsAdmin(String keyword, Integer pageSize, Integer pageNum);
}
