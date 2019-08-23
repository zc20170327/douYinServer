package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.service.PointDataService;
import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/login")
public class LoginController {
    @Autowired
    UserService userService;
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/")
    public RcsResult login(
            @ApiParam( name="userName", value="用户名") @RequestParam(value="userName",required=true) String userName,
            @ApiParam( name="password", value="密码") @RequestParam(value="password",required=true) String password
           ) {
        RcsResult result = userService.login(userName ,password);
        return result;
    }
}
