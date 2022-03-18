package com.rsh.dao;

import com.rsh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //数据库的基本操作 使用DBUtils操作数据库
    QueryRunner queryRunner=new QueryRunner();

    
    /*
    *update() 用来编写insert update delete
    * 如果返回-1，说明执行失败，返回其他说明是执行的行数
     */ 
    public int update(String sql,Object...args){
        Connection conn=JdbcUtils.getConnection();
        try {
           return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }
    
    /*
    * 查询一个JavaBean返回
    * type 返回的类型
    * sql   执行的sql语句
    * args  参数的数值
    * <T>   返回值的类型
    * */

    public <T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();
        try {
           return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    //查询多个
    /*
            * @Param: [type, sql, args]
            * @return: java.util.List<T>
            * @Author: rsh
            * @Date:2022/3/17 17:40
     */ 
    public <T>List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection conn=JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
    //执行返回一行一列的sql语句
    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn=JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }


}
