package org.cus.fx.order.dao;

import org.cus.fx.spgl.model.SpglModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table ordersp_table
 * @remarks
 */
public interface OrderSpDao {

    List<SpglModel> query(String sql);

    //    增删改
    int data(String sql);

}
