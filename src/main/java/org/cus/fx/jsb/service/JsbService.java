package org.cus.fx.jsb.service;

import org.cus.fx.account.model.AccountModel;
import org.cus.fx.jsb.model.JsbModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface JsbService {

    int add(JsbModel model);

    int update(JsbModel model);

    int delete(String id);

    List<JsbModel> get(String account,int page);
}
