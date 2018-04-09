package org.cus.fx.account.dao;


import org.cus.fx.account.model.AccountModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountDao {

    int data(String sql);

    List<AccountModel> get(String sql);
}
