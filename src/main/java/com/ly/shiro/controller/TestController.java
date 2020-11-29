package com.ly.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class TestController {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/test")
    public String test() throws SQLException {
        System.out.println(dataSource.getConnection());
        return "hello";
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "用户名不存在";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "用户名或密码错误";
        }catch (AuthorizationException e){
            e.printStackTrace();
            return "权限不足";
        }
        return "登录成功";

    }

    @GetMapping("/index")
    public String index(){
        return "首页";
    }

    @GetMapping("/admin")
    @RequiresRoles("admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    @RequiresRoles(value = {"admin","user"})
    public String user(){
        return "user";
    }

    @GetMapping("/root")
    @RequiresRoles("root")
    public String root(){
        return "root";
    }



}
