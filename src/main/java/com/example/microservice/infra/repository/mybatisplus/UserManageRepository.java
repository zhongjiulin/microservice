package com.example.microservice.infra.repository.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.repository.mybatisplus.dao.UserManageBaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author 钟玖林
 * @Date 2021/3/21 15:09
 * @Version 1.0
 */
@Repository
public class UserManageRepository extends ServiceImpl<UserManageBaseMapper, UmsAdmin> {
}
