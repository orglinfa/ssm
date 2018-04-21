package org.ssm.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dao.UserInfoMapper;
import org.ssm.pojo.UserInfo;

@Controller
@RequestMapping("/protal")
public class IndexController {
    private  static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public UserInfoMapper UserInfoMapper;
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println("========================");
        UserInfo userInfo=new UserInfo();
        userInfo.setId("2");
        userInfo.setUsername("test");
        System.out.println(UserInfoMapper);
        try{
            UserInfoMapper.insertSelective( userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("=====================");
        return "index str";
    }
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public UserInfo getUserInfo(@RequestParam  String id){
        System.out.println("==============="+id);
        System.out.println(logger);
        logger.error("===============查询用户id：==============="+id);
        return UserInfoMapper.selectByPrimaryKey(id);
    }
}
