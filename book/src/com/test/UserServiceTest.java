package com.test;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.pojo.User;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj168","666666","bbj168@qq.impl"));
        userService.registerUser(new User(null,"abc168","666666","bbj168@qq.impl"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"yz168","123456",null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("yz168")){
            System.out.println("用户名已存在！");
        }else{
            System.out.println("用户名可用！");
        }
    }
}