package com.lxl.controller;

import com.alibaba.druid.util.StringUtils;
import com.lxl.bean.userinfo;
import com.lxl.result.result;
import com.lxl.service.userinfoservice.userinfoservice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class userinfocontroller {
    @Autowired
    private userinfoservice userinfoservice;
    @DeleteMapping("/deleteuser")
    @ResponseBody
    public result deleteuser(@RequestBody String name){
        System.out.println(name);
        result result = new result();
        try{
            userinfoservice.deleteuserbyname(name);
            result.setMsg("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("服务器出错，请稍后再试");
            result.setResult(false);
        }
        return result;
    }
    @GetMapping("/getall")
    @ResponseBody
    public List<userinfo> getall(){
       return userinfoservice.getalluserinfo();
    }
    @PostMapping("add")
    @ResponseBody
    public result adduser(@RequestBody userinfo userinfo){
        System.out.println(userinfo);
        result result = new result();
        try {
            userinfoservice.adduserinfo(userinfo);
            result.setMsg("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("添加失败请稍后在试");
        }
        return result;
    }
    @PostMapping("/update")
    @ResponseBody
    public result update(@RequestBody userinfo userinfo){
        result result = new result();
        try {
            userinfoservice.updateuserinfo(userinfo);
            result.setMsg("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("修改失败");
            result.setResult(false);
        }
        return result;
        }

    @GetMapping("findbypage")
    @ResponseBody
    public Map<String,Object> finduserbypage(Integer pagenow,Integer pagesize){
        Map<String,Object> result=new HashMap<>();
        pagenow=pagenow==null ?1:pagenow;
        pagesize=pagesize==null?4:pagesize;
        List<userinfo> userinfos = userinfoservice.getusersbypage(pagenow, pagesize);
        result.put("users",userinfos);
        long getallcounts = userinfoservice.getallcounts();
        result.put("totals",getallcounts);
        return result;


    }

}
