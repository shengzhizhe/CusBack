package org.cus.fx.account.dao;

import org.cus.fx.account.model.AccountModel;
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
public class AccountDaoImpl implements AccountDao {
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
    public List<AccountModel> get(String sql) {
        List<AccountModel> list = new ArrayList<>();
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
                AccountModel model = new AccountModel();
                model.setUsername(result.getString(1));
                model.setPassword(result.getString(2));
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
