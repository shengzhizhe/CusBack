package org.cus.fx.account.service;

import org.cus.fx.account.dao.AccountDao;
import org.cus.fx.account.dao.AccountDaoImpl;
import org.cus.fx.account.model.AccountModel;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public int add(AccountModel model) {
        AccountDao dao = new AccountDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("insert into account_table (username,password)");
        sql.add(" values ");
        sql.add("('" + model.getUsername() + "','" + model.getPassword() + "')");
        return dao.data(sql.toString());
    }

    @Override
    public int update(AccountModel model) {
        AccountDao dao = new AccountDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("update account_table set password='" + model.getPassword()
                + "' where username='" + model.getUsername() + "'");
        return dao.data(sql.toString());
    }

    @Override
    public List<AccountModel> getByAccount(String account) {
        AccountDao dao = new AccountDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("select username,password from account_table where username = '" + account + "'");
        return dao.get(sql.toString());
    }
}
