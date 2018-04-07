package org.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/protal")
public class IndexController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index str";
    }
}
