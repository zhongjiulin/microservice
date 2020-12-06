package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsRole;
import com.example.microservice.infra.mapper.repository.UmsRoleRepository;
import com.example.microservice.infra.mapper.IUmsRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsRoleMapperImpl extends ServiceImpl<UmsRoleRepository, UmsRole> implements IUmsRoleMapper {

}
