package com.ggm;

import com.ggm.pojo.User;
import com.ggm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yz
 * @create 2021-11-24-19:31
 */
public class Client {
    User user1 = new User("666", "zhangsan", "87654321", "3123123141");
    User user2 = new User("777", "李四", "12345678", "11111111111");
    User user3 = new User("666", "李三", "87654321", "22222222222");
//    private UserService userService = new UserServiceImpl();
    private static UserService userService;
    static {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) app.getBean("userService");
    }

    @Test
    public void findAllUser() {
        System.out.println(userService.findAllUser());
    }

    @Test
    public void findUserById() {
        System.out.println(userService.findUserById("777"));
        System.out.println(userService.findUserById("111"));
    }

    @Test
    public void addUser() {
        userService.addUser(user1);
        userService.addUser(user2);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser("111");
    }

    @Test
    public void updateUser() {
        userService.updateUser(user3);
    }
}
