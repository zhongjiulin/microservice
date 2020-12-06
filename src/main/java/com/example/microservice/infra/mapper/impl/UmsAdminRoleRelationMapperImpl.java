package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsAdminRoleRelation;
import com.example.microservice.infra.mapper.repository.UmsAdminRoleRelationRepository;
import com.example.microservice.infra.mapper.IUmsAdminRoleRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsAdminRoleRelationMapperImpl extends ServiceImpl<UmsAdminRoleRelationRepository, UmsAdminRoleRelation> implements IUmsAdminRoleRelationMapper {

}
