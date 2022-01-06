package com.lxl.mapper;

import com.lxl.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface usermapper {
    user getuserByname(String name);
    List<user> getalluser();
    boolean adduser(user user);

}
