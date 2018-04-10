package org.cus.fx.spgl.dao;

import org.cus.fx.spgl.model.SpglModel;
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
public class SpglDaoImpl implements SpglDao {
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
            e.printStackTrace();
            return -1;
        } finally {
            JDBCUtils.release(ps, conn);
        }
    }

    @Override
    public List<SpglModel> get(String sql) {
        List<SpglModel> list = new ArrayList<>();
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
                SpglModel model = new SpglModel();
                model.setUuid(result.getString("uuid"));
                model.setCname(result.getString("cname"));
                model.setJg(result.getDouble("jg"));
                model.setDw(result.getString("dw"));
                model.setGe(result.getString("ge"));
                model.setZt(result.getString("zt"));
                model.setPp(result.getString("pp"));
                model.setXq(result.getString("xq"));
                model.setXl(result.getString("xl"));
                model.setBusid(result.getString("busid"));
                model.setSl(result.getInt("sl"));
                model.setLm(result.getString("lm"));
                model.setSxj(result.getInt("sxj"));
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
