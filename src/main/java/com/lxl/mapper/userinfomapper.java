package com.lxl.mapper;

import com.lxl.bean.user;
import com.lxl.bean.userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userinfomapper {
    List<userinfo> findalluser();
    void adduserinfo(userinfo userinfo);
    void deletebyname(String name);
    void updateuserinfo(userinfo userinfo);
    //分页查询
    List<userinfo> getusersbypage(@Param("start") Integer start,@Param("rows") Integer rows);
    //获取总记录数
    Long findallsize();
}
