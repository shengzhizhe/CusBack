package org.cus.fx.spgl.service;

import org.cus.fx.spgl.model.SpglModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface SpglService {

    int add(SpglModel model);

    int update(SpglModel model);

    int delete(String id);

    List<SpglModel> get(String account, int page);
}
