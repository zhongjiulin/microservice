package com.example.microservice.infra.mapper.impl;

import com.example.microservice.domain.UmsMenu;
import com.example.microservice.infra.mapper.repository.UmsMenuRepository;
import com.example.microservice.infra.mapper.IUmsMenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UmsMenuMapperImpl extends ServiceImpl<UmsMenuRepository, UmsMenu> implements IUmsMenuMapper {

}
