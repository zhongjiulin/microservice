package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsRolePermissionRelation;
import com.example.microservice.infra.mapper.repository.UmsRolePermissionRelationRepository;
import com.example.microservice.infra.mapper.IUmsRolePermissionRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色和权限关系表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsRolePermissionRelationMapperImpl extends ServiceImpl<UmsRolePermissionRelationRepository, UmsRolePermissionRelation> implements IUmsRolePermissionRelationMapper {

}
