package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsAdminPermissionRelation;
import com.example.microservice.infra.mapper.repository.UmsAdminPermissionRelationRepository;
import com.example.microservice.infra.mapper.IUmsAdminPermissionRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsAdminPermissionRelationMapperImpl extends ServiceImpl<UmsAdminPermissionRelationRepository, UmsAdminPermissionRelation> implements IUmsAdminPermissionRelationMapper {

}
