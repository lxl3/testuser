package com.lxl.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userinfo {
   private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private  String username;
    private String sex;
    private String province;
    private String urban;
    private String address;
}
