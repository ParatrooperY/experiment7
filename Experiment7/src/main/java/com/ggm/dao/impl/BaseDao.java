package com.ggm.dao.impl;

import com.ggm.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yz
 * @create 2021-11-22-10:41
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner =new QueryRunner();

    /**
     * update()方法用来执行，Insert\Update\Delete语句
     * @return 如果返回-1，说明执行失败；返回其他表示影响的行数
     */
    public int update(String sql,Object...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回单个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args 返回的类型的泛型
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args 返回的类型的泛型
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type,String sql,Object...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
