package org.cus.fx.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JDBC {
    public ResultSet query(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            //创建连接
            conn = JDBCUtils.getConnetions();
            //创建prepareStatement对象，用于执行SQL
            ps = conn.prepareStatement(new String(sql.getBytes("UTF-8"),"UTF-8"));
            //获取查询结果集
            result = ps.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(result, ps, conn);
        }
        return null;
    }

    public int data(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //创建数据库连接
            conn = JDBCUtils.getConnetions();
            //创建执行SQL的prepareStatement对象
            ps = conn.prepareStatement(new String(sql.getBytes("UTF-8"),"UTF-8"));
            //用于增删改操作
            int result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            JDBCUtils.release(ps, conn);
        }
    }
}
