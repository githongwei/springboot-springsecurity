package com.pack.controller;

import com.pack.po.User;
import com.pack.service.UserService;
import com.pack.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关控制层
 * @author zhaohongwei
 * @Date 2018/05/19
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "/index";
    }

    @RequestMapping("/register")
    public String register(User user){
        if(user.getName()!=null){
           userService.addUser(user);
            return "/login";
        }
        return "/register";
    }

}
