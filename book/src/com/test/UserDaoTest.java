package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("yz168") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户不可用！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("yyyz168", "123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"admin","123456","yz168@qq.impl")));
    }
}