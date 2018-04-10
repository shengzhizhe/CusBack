package org.cus.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.account.service.AccountService;
import org.cus.fx.account.service.AccountServiceImpl;
import org.cus.fx.home.controller.HomeController;
import org.cus.fx.util.Base64Util;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class IndexController {

    //    名称必须和fx:id保持一至，类型也必须一至
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;

    @FXML
    private void reset(ActionEvent event) {
        account.setText("xuesemofa@163.com");
        password.setText("1234567aA");
        error.setText(null);
    }

    @FXML
    private void login(ActionEvent event) {
        String account = this.account.getText();
        String password = this.password.getText();
        if (account == null || password == null) {
            error.setText("账户密码不能为空");
        } else {
            AccountService accountService = new AccountServiceImpl();
            List<AccountModel> byAccount = accountService.getByAccount(account);
            if (byAccount.size() > 0) {
                String s = Base64Util.decode(byAccount.get(0).getPassword());
                if (s.equals(password)) {
                    try {
                        HomeController homeController = new HomeController();
                        homeController.init(account);
                    } catch (Exception e) {
                        e.printStackTrace();
                        error.setText("跳转异常");
                    }
                } else
                    error.setText("账户密码错误");
            } else
                error.setText("账户密码错误");
        }
    }
}
