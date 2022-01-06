package com.lxl.service;

import com.lxl.bean.user;
import com.lxl.mapper.usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userserviceImpl  implements userservice{
    @Autowired
    private usermapper usermapper;
    @Override
    public user getuserbyName(String name) {
        return usermapper.getuserByname(name);
    }

    @Override
    public List<user> getalluser() {
        return usermapper.getalluser();
    }

    @Override
    public boolean adduser(user user) {
        boolean res;
        try {
             res = usermapper.adduser(user);
        }catch (Exception e){
            e.printStackTrace();
            res=false;
        }
        return res;
    }
}
