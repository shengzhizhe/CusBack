package org.cus.fx.order.dao;

import org.cus.fx.order.model.OrderModel;
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
public class OrderDaoImpl implements OrderDao {

    @Override
    public List<OrderModel> query(String sql) {
        List<OrderModel> list = new ArrayList<>();
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
                OrderModel model = new OrderModel();
                model.setUuid(result.getString("uuid"));
                model.setSpid(result.getString("spid"));
                model.setSl(result.getString("sl"));
                model.setZj(result.getString("zj"));
                model.setAddress(result.getString("address"));
                model.setPhone(result.getString("phone"));
                model.setDdbh(result.getString("ddbh"));
                model.setCjTime(result.getString("cjtime"));
                model.setAccount(result.getString("account"));
                model.setType(result.getInt("type"));
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
}