package com.wuyanzu.controller;

import com.wuyanzu.pojo.Emp;
import com.wuyanzu.pojo.Result;
import com.wuyanzu.service.EmpService;
import com.wuyanzu.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录:{}", emp);
        //调用service登录验证
        Emp e = empService.login(emp);
        //登录成功返回JWT令牌
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        //登录失败
        return Result.error("用户名或者密码错误！");
    }
}
