package org.cus.fx.order.service;

import org.cus.fx.order.model.OrderSpModel;
import org.cus.fx.spgl.model.SpglModel;

import java.util.List;

public interface OrderSpService {

    List<SpglModel> getByOrderId(String id);

    int update(OrderSpModel model);

}
