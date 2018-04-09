package org.cus.fx.jsb.dao;


import org.cus.fx.jsb.model.JsbModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface JsbDao {

    int data(String sql);

    List<JsbModel> get(String sql);
}
