package com.example.microservice.app.mapper.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.app.mapper.UserManageMapper;
import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.repository.mybatisplus.UserManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */
@Service
public class UserManageMapperImpl implements UserManageMapper {
    @Autowired
    private UserManageRepository userManageRepository;

    @Override
    public UmsAdminDTO getByUsername(String username) {
        LambdaQueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<UmsAdmin>().lambda();
        queryWrapper.eq(UmsAdmin::getUsername, username);
        return UmsAdminDTO.build(userManageRepository.getOne(queryWrapper));
    }

    @Override
    public Page<UmsAdminDTO> listUmsAdmin(String keyword, Integer pageSize, Integer pageNum) {
        LambdaQueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<UmsAdmin>().lambda();
        queryWrapper.eq(StrUtil.isNotBlank(keyword), UmsAdmin::getUsername, keyword)
                .or().eq(StrUtil.isNotBlank(keyword), UmsAdmin::getNickName, keyword);
        IPage<UmsAdmin> page = new Page<>(pageNum, pageSize);
        IPage<UmsAdmin> iPage = userManageRepository.page(page, queryWrapper);

        Page<UmsAdminDTO> result = new Page<>();
        List<UmsAdminDTO> umsAdminDTOS = iPage.getRecords().stream()
                .map(ele -> UmsAdminDTO.build(ele)).collect(Collectors.toList());
        result.setCurrent(iPage.getCurrent()).setPages(iPage.getPages())
                .setPages(iPage.getPages()).setTotal(iPage.getTotal()).setRecords(umsAdminDTOS);
        return result;
    }

    @Override
    public UmsAdmin getById(Long id) {
        return null;
    }

    @Override
    public void save(UmsAdmin umsAdmin) {
        userManageRepository.save(umsAdmin);
    }
}
