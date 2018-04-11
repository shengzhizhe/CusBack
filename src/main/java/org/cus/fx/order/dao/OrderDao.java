package org.cus.fx.order.dao;

import org.cus.fx.order.model.OrderModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table order_table
 * @remarks
 */
public interface OrderDao {

    List<OrderModel> query(String sql);

    //    增删改
    int data(String sql);

}
