package com.ggm.service;

import com.ggm.pojo.User;

import java.util.List;

/**
 * @author yz
 * @create 2021-11-22-19:07
 */
public interface UserService {
    /**
     * 查找所有用户信息
     * @return 返回所有用户信息
     */
    public List<User> findAllUser();

    /**
     * 查找用户
     * @param userId
     * @return 返回查询的用户信息
     */
    public User findUserById(String userId);

    /**
     * 添加用户信息
     * @param user
     * @return 返回true表示添加成功
     */
    public Boolean addUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return 返回true表示删除成功
     */
    public Boolean deleteUser(String userId);

    /**
     * 更新用户信息
     * @param user
     * @return 返回true表示更新成功
     */
    public Boolean updateUser(User user);
}
