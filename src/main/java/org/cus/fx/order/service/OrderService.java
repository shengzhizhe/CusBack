package org.cus.fx.order.service;

import org.cus.fx.order.model.OrderModel;

import java.util.List;

public interface OrderService {
    /**
     * 订单分页
     *
     * @param pageNow 当前页数
     * @param zt      订单状态，如果为空则所有订单，如果传入订单类型则相关类型分类
     * @return List<OrderModel>
     */
    List<OrderModel> page(int pageNow, String zt);

    List<OrderModel> getById(String id);

    int update(OrderModel model);

    int add(OrderModel model);

    int del(String id);
}
