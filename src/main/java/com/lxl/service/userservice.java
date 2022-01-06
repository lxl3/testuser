package com.lxl.service;

import com.lxl.bean.user;

import java.util.List;

public interface userservice {
    user getuserbyName(String name);
    List<user> getalluser();
    boolean adduser(user user);
}
