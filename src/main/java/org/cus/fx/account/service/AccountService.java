package org.cus.fx.account.service;

import org.cus.fx.account.model.AccountModel;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountService {

    int add(AccountModel model);

    int update(AccountModel model);

    List<AccountModel> getByAccount(String account);
}
