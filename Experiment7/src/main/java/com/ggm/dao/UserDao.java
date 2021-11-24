package com.ggm.dao;

import com.ggm.pojo.User;

import java.util.List;

/**
 * @author yz
 * @create 2021-11-22-10:41
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param userId 用户id
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User query(String userId);

    /**
     * 返回所有用户
     * @return 如果返回null，说明没有任何用户信息
     */
    public List<User> queryAll();
    /**
     * 添加新用户
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int insert(User user);
    /**
     * 删除用户信息
     * @param userId
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int delete(String userId);
    /**
     * 更改用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int update(User user);
}
