package com.rsh.test;

import com.rsh.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i=0;i<20;i++){
            Connection conn=JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }
}
