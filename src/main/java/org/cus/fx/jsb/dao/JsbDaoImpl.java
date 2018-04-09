package org.cus.fx.jsb.dao;

import org.cus.fx.jsb.model.JsbModel;
import org.cus.fx.util.jdbc.JDBCUtils;

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
public class JsbDaoImpl implements JsbDao {
    @Override
    public int data(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //创建数据库连接
            conn = JDBCUtils.getConnetions();
            //创建执行SQL的prepareStatement对象
            ps = conn.prepareStatement(sql);
            //用于增删改操作
            int result = ps.executeUpdate();
            return result;
        } catch (Exception e) {
            System.out.println("出现异常1=" + e.toString());
            return -1;
        } finally {
            JDBCUtils.release(ps, conn);
        }
    }

    @Override
    public List<JsbModel> get(String sql) {
        List<JsbModel> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            //创建连接
            conn = JDBCUtils.getConnetions();
            //创建prepareStatement对象，用于执行SQL
            ps = conn.prepareStatement(sql);
            //获取查询结果集
            result = ps.executeQuery();
            while (result.next()) {
                JsbModel model = new JsbModel();
                model.setUuid(result.getString(1));
                model.setRq(result.getString(2));
                model.setTitles(result.getString(3));
                model.setBodys(result.getString(4));
                list.add(model);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            JDBCUtils.release(result, ps, conn);
        }
    }
}
