package com.example.microservice.infra.mapper.repository;

import com.example.microservice.domain.UmsAdminPermissionRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) Mapper 接口
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
public interface UmsAdminPermissionRelationRepository extends BaseMapper<UmsAdminPermissionRelation> {

}
