package com.pack.service.imp;

import com.pack.dao.UserDao;
import com.pack.po.User;
import com.pack.service.UserService;
import com.pack.util.MD5Util;
import com.pack.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String name) {
        if (null != name){
            User user = userDao.selectUser(name);
            return user;
        }
        return null;
    }

    @Override
    public List<User> userAll() {
        return userDao.findAll();
    }

    @Override
    public Msg addUser(User user) {
        try {
            if("".equals(user.getName())) {
                return new Msg("用户名不能为空", "测试注册", 500);
            }
            if ("".equals(user.getPassword())){
                return new Msg("密码不能为空","测试注册",500);
            }
            User userMessage = userDao.selectUser(user.getName());
            if(userMessage != null){
                return new Msg("该用户已被注册","测试注册",500);
            }
            user.setPassword(MD5Util.encode(user.getPassword()));
            userDao.save(user);
            return new Msg("注册成功","测试注册",200);
        }catch (Exception e){
            e.printStackTrace();
            return new Msg("注册失败","测试注册",500);
        }

    }
}
