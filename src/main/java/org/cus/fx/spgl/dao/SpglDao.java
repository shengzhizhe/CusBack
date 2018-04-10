package org.cus.fx.spgl.dao;


import org.cus.fx.spgl.model.SpglModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface SpglDao {

    int data(String sql);

    List<SpglModel> get(String sql);
}
