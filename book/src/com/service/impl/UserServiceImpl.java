package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;
import com.pojo.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            //没查到
            return false;
        }else {
            return  true;
        }
    }
}
