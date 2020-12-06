package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.mapper.repository.UmsAdminRepository;
import com.example.microservice.infra.mapper.IUmsAdminMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsAdminMapperImpl extends ServiceImpl<UmsAdminRepository, UmsAdmin> implements IUmsAdminMapper {

}
