package com.lxl.controller;

import com.lxl.util.VerificationUtil;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@CrossOrigin
public class vertifycodecontroller {
    @PostMapping("getvercode")
    @ResponseBody
    public String getvercode(HttpServletRequest request){
        String verifyCode = VerificationUtil.generateVerifyCode(4);
//        request.setAttribute("yzm",verifyCode);
        request.getServletContext().setAttribute("yzm",verifyCode);
        //创建字节数组缓冲
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            //生成验证码图片以字节存入缓冲区
            VerificationUtil.outputImage(100,38,byteArrayOutputStream,verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将缓冲字节数组转为base64
        String base64 = Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
        //将base64返回给前端
        return "data:image/png;base64," + base64;
    }
}
