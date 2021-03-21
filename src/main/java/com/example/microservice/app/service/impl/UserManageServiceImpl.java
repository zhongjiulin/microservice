package com.example.microservice.app.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.app.service.UserManageService;
import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.config.JwtConfig;
import com.example.microservice.app.mapper.UserManageMapper;
import com.example.microservice.infra.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:01
 * @Version 1.0
 */

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private UserManageMapper userManageMapper;

    @Override
    public Page<UmsAdminDTO> listUmsAdmin(String keyword, Integer pageSize, Integer pageNum) {

        return userManageMapper.listUmsAdmin(keyword, pageSize, pageNum);
    }

    @Override
    public UmsAdminDTO getOne(Long id) {
        UmsAdmin umsAdmin = userManageMapper.getById(id);
        return UmsAdminDTO.build(umsAdmin);
    }

    @Override
    public UmsAdmin insert(UmsAdminDTO userDTO) {
        UmsAdmin umsAdmin = UmsAdmin.build(userDTO);
        userManageMapper.save(umsAdmin);
      return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        UmsAdminDTO umsAdminDTO = userManageMapper.getByUsername(username);
        if (umsAdminDTO == null || !SecureUtil.md5(password).equals(umsAdminDTO.getPassword())) {
            return "";
        }
        return JwtUtil.sign(username, jwtConfig);
    }
}
