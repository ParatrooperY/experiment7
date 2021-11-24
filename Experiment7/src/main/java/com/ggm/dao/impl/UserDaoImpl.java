package com.ggm.dao.impl;

import com.ggm.dao.UserDao;
import com.ggm.pojo.User;

import java.util.List;

/**
 * @author yz
 * @create 2021-11-22-14:15
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    public User query(String userId) {
        String sql = "select `userId`,`username`,`password`,`phone` from t_user where userId = ?";
        return queryForOne(User.class,sql,userId);
    }

    public List<User> queryAll() {
        String sql = "select * from t_user";
        return queryForList(User.class,sql);
    }

    public int insert(User user) {
        String sql = "insert into t_user(`userId`,`username`,`password`,`phone`) value(?,?,?,?)";
        return update(sql,user.getUserId(),user.getUsername(),user.getPassword(),user.getPhone());
    }

    public int delete(String userId) {
        String sql = "delete from t_user where userId = ?";
        return update(sql,userId);
    }

    public int update(User user) {
        String sql = "update t_user set username = ?, password = ? where userId = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getUserId());
    }
}
