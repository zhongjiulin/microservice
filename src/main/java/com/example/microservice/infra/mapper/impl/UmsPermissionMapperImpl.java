package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsPermission;
import com.example.microservice.infra.mapper.repository.UmsPermissionRepository;
import com.example.microservice.infra.mapper.IUmsPermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsPermissionMapperImpl extends ServiceImpl<UmsPermissionRepository, UmsPermission> implements IUmsPermissionMapper {

}
