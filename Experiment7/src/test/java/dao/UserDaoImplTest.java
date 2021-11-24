package dao;

import com.ggm.dao.UserDao;
import com.ggm.dao.impl.UserDaoImpl;
import com.ggm.pojo.User;
import org.junit.Test;

/**
 * @author yz
 * @create 2021-11-22-19:33
 */
public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    User user1 = new User("999","zhangsan","87654321","01987654321");
    User user2 = new User("888","李四","12345678","11111111111");
    User user3 = new User("999","李四","87654321","22222222222");

    @Test
    public void query() {
        System.out.println(userDao.query("111"));
    }

    @Test
    public void queryAll() {
        System.out.println(userDao.queryAll());
    }

    @Test
    public void insert() {
        userDao.insert(user1);
    }

    @Test
    public void delete() {
        userDao.delete("111");
    }

    @Test
    public void update() {
        userDao.update(user3);
    }
}