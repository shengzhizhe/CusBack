package org.cus.fx;

import com.sun.javafx.robot.impl.FXRobotHelper;
import feign.FeignException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.api.AccountInterface;
import org.cus.fx.home.controller.HomeController;
import org.cus.fx.util.AlertUtil;
import org.cus.fx.util.Base64Util;
import org.cus.fx.util.LoggerUtil;
import org.cus.fx.util.ResponseResult;
import org.cus.fx.util.feign.FeignUtil;

import java.util.logging.Logger;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class.toString());

    //    名称必须和fx:id保持一至，类型也必须一至
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;

    @FXML
    private TextField res_acc;
    @FXML
    private TextField res_pwd;
    @FXML
    private Label res_error;

    @FXML
    private void register(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/register/register.fxml"));
//        获取stage
            ObservableList<Stage> stages = FXRobotHelper.getStages();
//        设置为新的内容窗口
            Stage primaryStage = stages.get(0);
            primaryStage.setTitle("注册");
            primaryStage.getScene().setRoot(root);
//        显示
            primaryStage.show();
        } catch (Exception e) {
            logger.info(new LoggerUtil(IndexController.class, "reigster", e.getMessage()).toString());
        }
    }

    @FXML
    private void register_data(ActionEvent event) {
        AlertUtil alertUtil = new AlertUtil();
        try {
            String account = res_acc.getText();
            String pwd = res_pwd.getText();
            AccountModel model = new AccountModel();
            model.setUsername(account);
            model.setPassword(pwd);
            FeignUtil feignUtil = new FeignUtil();
            AccountInterface anInterface = (AccountInterface) feignUtil.getInterface(null);
            ResponseResult<AccountModel> register = anInterface.register(model);
            if (register.isSuccess()) {
                alertUtil.f_alert_informationDialog("提示", "成功");
                register_login(event);
            } else
                alertUtil.f_alert_informationDialog("警告", register.getMessage());
        } catch (FeignException f) {
            logger.info(new LoggerUtil(IndexController.class, "reigster_data", "服务器通讯异常").toString());
            alertUtil.f_alert_informationDialog("警告", "服务器通讯异常");
        } catch (Exception e) {
            logger.info(new LoggerUtil(IndexController.class, "reigster_data", "注册失败").toString());
            alertUtil.f_alert_informationDialog("警告", "失败");
        }
    }

    @FXML
    private void register_login(ActionEvent event) {
        try {
            //        获取stage
            ObservableList<Stage> stages = FXRobotHelper.getStages();
//        设置为新的内容窗口
            Stage primaryStage = stages.get(0);
            new App().index(primaryStage);
        } catch (Exception e) {
            logger.info(new LoggerUtil(IndexController.class, "register_login", "跳转异常").toString());
        }
    }

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
            FeignUtil feignUtil = new FeignUtil();
            AccountInterface anInterface = (AccountInterface) feignUtil.getInterface(null);
            AccountModel model = new AccountModel();
            model.setUsername(account);
            model.setPassword(password);
            model.setTypes(1);
            ResponseResult<AccountModel> result = anInterface.login(model);
            AccountModel data = result.getData();
            if (result.isSuccess()) {
                String s = Base64Util.decode(data.getPassword());
                if (s.equals(password)) {
                    try {
                        HomeController homeController = new HomeController();
                        homeController.init(account);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.info(new LoggerUtil(IndexController.class, "login", "跳转异常").toString());
                        error.setText("跳转异常");
                    }
                } else
                    error.setText("账户密码错误");
            } else
                error.setText(result.getMessage());
        }
    }
}
