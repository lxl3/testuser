package com.lxl;

import com.lxl.bean.user;
import com.lxl.bean.userinfo;
import com.lxl.mapper.userinfomapper;
import com.lxl.service.userservice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class TestuserApplicationTests {
    @Autowired
    private com.lxl.service.userservice userservice;
    @Test
    void contextLoads() {
    }
    @Test
    public void testgetuser(){
        user user = userservice.getuserbyName("李磊");
        System.out.println(user);

    }
    @Test
    public void testgetall(){
        List<user> users = userservice.getalluser();
        System.out.println(users);
    }
    @Test
    public void testadd(){
        user user = new user();
        user.setEmail("21312@163.com");
        user.setPassword("1234");
        user.setUsername("韩梅梅");
        boolean res = userservice.adduser(user);
        System.out.println(res);

    }
    @Autowired
    private userinfomapper userinfomapper;
    @Test
    public void testgetalluser(){
        List<userinfo> users = userinfomapper.findalluser();
        System.out.println(users);
    }
    @Test
    public void testupdate(){
        userinfo userinfo = new userinfo();
        userinfo.setDate(new Date());
        userinfo.setUsername("李磊");
        userinfo.setSex("女");
        userinfo.setProvince("河南省");
        userinfo.setUrban("南阳市");
        userinfo.setAddress("淅川县沙渠河村");
        userinfomapper.updateuserinfo(userinfo);
    }
    @Test
    public void testdelete(){
        userinfomapper.deletebyname("王小虎");
    }
    @Test
    public void testadduserinfo(){
        userinfo userinfo = new userinfo();
//        userinfo.setId("2");
        userinfo.setDate(new Date());
        userinfo.setUsername("小明");
        userinfo.setSex("女");
        userinfo.setProvince("湖北");
        userinfo.setUrban("十堰");
        userinfo.setAddress("郧阳区");
        System.out.println(userinfo);
        userinfomapper.adduserinfo(userinfo);
    }
    @Test
    public void test(){
        System.out.println(new Date());
    }
    @Test
    public void testupdate2(){
        userinfo userinfo = new userinfo();
        userinfo.setDate(new Date());
        userinfo.setUsername("lidas");
        userinfo.setAddress("湖北神");
        userinfo.setUrban("dashih");
        userinfo.setSex("女");
        userinfomapper.updateuserinfo(userinfo);


    }
}
