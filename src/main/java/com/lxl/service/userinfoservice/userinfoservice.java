package com.lxl.service.userinfoservice;


import com.lxl.bean.userinfo;


import java.util.List;


public interface userinfoservice {
       List<userinfo> getalluserinfo();
       void deleteuserbyname(String name);
       void adduserinfo(userinfo userinfo);
       void updateuserinfo(userinfo userinfo);
       List<userinfo> getusersbypage(Integer start,Integer rows);
       long getallcounts();
}
