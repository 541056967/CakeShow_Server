package com.wonderland.server.controller;


import com.wonderland.server.pojo.Admin;
import com.wonderland.server.pojo.AdminLoginParam;
import com.wonderland.server.pojo.ResBean;
import com.wonderland.server.service.impl.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


/**
 * 登录
 * */
@Api(tags = "loginController")
@RestController
public class LoginController {

    private IAdminService adminService;

    @ApiOperation(value = "登陆之后返回token")
    @PostMapping("/login")
    public ResBean login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @PostMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(principal == null){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;

    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public ResBean logout(){
        return ResBean.success("注销成功");
    }
}
