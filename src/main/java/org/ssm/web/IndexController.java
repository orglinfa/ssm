package org.ssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dao.UserInfoMapper;
import org.ssm.pojo.UserInfo;

@Controller
@RequestMapping("/protal")
public class IndexController {
    @Autowired
    public UserInfoMapper UserInfoMapper;
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println("========================");
        UserInfo userInfo=new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("test");
        UserInfoMapper.insert( userInfo);
        return "index str";
    }
}
