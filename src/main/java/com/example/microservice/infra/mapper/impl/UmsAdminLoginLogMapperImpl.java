package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsAdminLoginLog;
import com.example.microservice.infra.mapper.repository.UmsAdminLoginLogRepository;
import com.example.microservice.infra.mapper.IUmsAdminLoginLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsAdminLoginLogMapperImpl extends ServiceImpl<UmsAdminLoginLogRepository, UmsAdminLoginLog> implements IUmsAdminLoginLogMapper {

}
