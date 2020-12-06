package com.example.microservice.app.service.impl;

import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.app.service.IUmsAdminService;
import com.example.microservice.domain.UmsAdmin;
import com.example.microservice.infra.mapper.IUmsAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 钟玖林
 * @Date 2020/11/29 10:01
 * @Version 1.0
 */

@Service
public class UmsAdminServiceImpl implements IUmsAdminService {
    @Autowired
    private IUmsAdminMapper umsAdminMapper;

    @Override
    public List<UmsAdminDTO> getAll() {
        List<UmsAdmin> umsAdmins = umsAdminMapper.list();

        return UmsAdminDTO.build(umsAdmins);
    }

    @Override
    public UmsAdminDTO getOne(Long id) {
        UmsAdmin umsAdmin = umsAdminMapper.getById(id);
        return UmsAdminDTO.build(umsAdmin);
    }

    @Override
    public UmsAdmin insert(UmsAdminDTO userDTO) {
        UmsAdmin umsAdmin = UmsAdmin.build(userDTO);
        umsAdminMapper.save(umsAdmin);
      return umsAdmin;
    }
}
