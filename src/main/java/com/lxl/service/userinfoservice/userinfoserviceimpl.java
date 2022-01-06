package com.lxl.service.userinfoservice;

import com.lxl.bean.userinfo;
import com.lxl.mapper.userinfomapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userinfoserviceimpl implements userinfoservice{


    @Autowired
    private userinfomapper userinfomapper;
    @Override
    public List<userinfo> getalluserinfo() {
        return userinfomapper.findalluser();
    }

    @Override
    public void deleteuserbyname(String name) {
        userinfomapper.deletebyname(name);

    }
    @Override
    public void adduserinfo(userinfo userinfo) {
            userinfomapper.adduserinfo(userinfo);
    }

    @Override
    public void updateuserinfo(userinfo userinfo) {
        userinfomapper.updateuserinfo(userinfo);
    }

    @Override
    public List<userinfo> getusersbypage(Integer pageNow, Integer rows) {
        Integer start=(pageNow-1)*rows;
        return userinfomapper.getusersbypage(start,rows);
    }

    @Override
    public long getallcounts() {
        return userinfomapper.findallsize();
    }
}
