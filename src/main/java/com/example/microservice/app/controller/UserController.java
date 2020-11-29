package com.example.microservice.app.controller;


import com.example.microservice.app.dto.UserDTO;
import com.example.microservice.app.service.IUserService;
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
 * @Author 钟玖林
 * @Date 2020/11/29 9:33
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理接口")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ApiResult getUsers() {
        List<UserDTO> userDTOs = userService.getAll();
        return ApiResult.ok(userDTOs);
    }

    @ApiOperation("根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, paramType = "path", dataType = "Long")})
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ApiResult getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getOne(id);
        return ApiResult.ok(userDTO);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult save(@Valid @RequestBody UserDTO userDTO) {
        userService.insert(userDTO);
        return ApiResult.ok();
    }
}
