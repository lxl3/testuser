package com.lxl.controller;

import com.lxl.bean.user;
import com.lxl.ov.loginform;
import com.lxl.result.result;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller("/")
@ResponseBody
public class usercontroller {
    @Autowired
    private com.lxl.service.userservice userservice;
    @PostMapping("/register")
    public result adduser(@RequestBody user user){

        System.out.println(user);
        result result = new result();
        try{
            userservice.adduser(user);
            result.setMsg("注册成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("抱歉服务器出现故障，请稍后再试!!!");
        }
        return result;
    }
    @PostMapping("/login")
    @ResponseBody
    public result login(@RequestBody loginform loginform, HttpServletRequest request){
        System.out.println(loginform);
        Object yzm = request.getServletContext().getAttribute("yzm");
        String code = yzm.toString().toLowerCase();
        System.out.println(code);
        result result = new result();
        String username = loginform.getUsername();
        user user = userservice.getuserbyName(username);
        if(user==null){
            result.setMsg("用户名不存在");
            result.setResult(false);
            return result;
        }
        String password = user.getPassword();
        System.out.println(password);
        if(loginform.getPassword()!=null && password.equals(loginform.getPassword()) && loginform.getIdentifyingCode().equals(code)){
            result.setMsg("登录成功");
        }else{
            result.setMsg("信息有误，登录失败");
            result.setResult(false);
        }
        return result;
    }


}
