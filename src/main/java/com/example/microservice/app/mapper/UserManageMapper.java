package com.example.microservice.app.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.domain.UmsAdmin;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
public interface UserManageMapper {
    /**
     * 通过名字查找用户
     * @param username
     * @return
     */
    UmsAdminDTO getByUsername(String username);

    /**
     * 获取用户列表
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<UmsAdminDTO> listUmsAdmin(String keyword, Integer pageSize, Integer pageNum);

    UmsAdmin getById(Long id);

    void save(UmsAdmin umsAdmin);
}
