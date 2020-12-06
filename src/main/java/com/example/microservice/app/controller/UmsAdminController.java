package com.example.microservice.app.controller;

import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.app.service.IUmsAdminService;
import com.example.microservice.infra.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */

@RestController
@RequestMapping("/umsAdmin")
@Api(tags = "用户管理接口")
public class UmsAdminController {
    @Autowired
    private IUmsAdminService umsAdminService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ApiResult getUsers() {
        List<UmsAdminDTO> userDTOs = umsAdminService.getAll();
        return ApiResult.ok(userDTOs);
    }

    @ApiOperation("根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, paramType = "path", dataType = "Long")})
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ApiResult getUser(@PathVariable Long id) {
        UmsAdminDTO userDTO = umsAdminService.getOne(id);
        return ApiResult.ok(userDTO);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult save(@Valid @RequestBody UmsAdminDTO userDTO) {
        umsAdminService.insert(userDTO);
        return ApiResult.ok();
    }
}
