package com.ggm.service.impl;

import com.ggm.dao.UserDao;
import com.ggm.pojo.User;
import com.ggm.service.UserService;

import java.util.List;

/**
 * @author yz
 * @create 2021-11-22-16:25
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAllUser() {
        return userDao.queryAll();
    }

    public User findUserById(String userId) {
        return userDao.query(userId);
    }

    public Boolean addUser(User user) {
        if (userDao.insert(user) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteUser(String userId) {
        if (userDao.delete(userId) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateUser(User user) {
        if (userDao.update(user) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
