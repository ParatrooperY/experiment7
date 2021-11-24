package service;

import com.ggm.pojo.User;
import com.ggm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yz
 * @create 2021-11-22-19:32
 */
public class UserServiceImplTest {

    User user1 = new User("777", "zhangsan", "87654321", "11987654321");
    User user2 = new User("888", "李四", "12345678", "11111111111");
    User user3 = new User("777", "李四", "87654321", "22222222222");

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
        System.out.println(userService.findUserById("999"));
    }

    @Test
    public void addUser() {
        userService.addUser(user1);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser("999");
    }

    @Test
    public void updateUser() {
        userService.updateUser(user3);
    }
}