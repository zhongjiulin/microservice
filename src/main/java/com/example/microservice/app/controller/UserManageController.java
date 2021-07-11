package com.example.microservice.app.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microservice.app.dto.UmsAdminDTO;
import com.example.microservice.app.service.UserManageService;
import com.example.microservice.infra.constant.HttpStatusEnum;
import com.example.microservice.infra.utils.ApiResult;
import com.example.microservice.infra.utils.PageApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author 钟玖林10265666
 * @since 2020-12-06
 */

@RestController
@RequestMapping("/admin")
@Api(tags = "用户管理接口")
public class UserManageController {
    @Autowired
    private UserManageService umsAdminService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<String> login(@RequestParam String userName, @RequestParam String password) {
        ApiResult<String> apiResult = new ApiResult<>();
        String token = umsAdminService.login(userName, password);
        if (StrUtil.isBlank(token)) {
            return apiResult.error(HttpStatusEnum.C403.getCode(), HttpStatusEnum.C403.getMessage());
        }
        return apiResult.success(token);
    }

    @ApiOperation("根据账号或姓名获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageApiResult<UmsAdminDTO> listUmsAdmin(@RequestParam(value = "keyword", required = false) String keyword,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsAdminDTO> userDTOs = umsAdminService.listUmsAdmin(keyword, pageSize, pageNum);
        return new PageApiResult<>(userDTOs);
    }


    @ApiOperation("根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, paramType = "path", dataType = "Long")})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getUser(@PathVariable Long id) {
        ApiResult<UmsAdminDTO> apiResult = new ApiResult<>();
        UmsAdminDTO userDTO = umsAdminService.getOne(id);
        return apiResult.success(userDTO);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult<String> save(@Validated @RequestBody UmsAdminDTO userDTO) {
        ApiResult<String> apiResult = new ApiResult<>();
        umsAdminService.insert(userDTO);
        return apiResult.success("success");
    }

}
