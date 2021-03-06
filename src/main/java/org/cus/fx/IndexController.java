package org.cus.fx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.robot.impl.FXRobotHelper;
import feign.FeignException;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.api.AccountInterface;
import org.cus.fx.home.controller.HomeController;
import org.cus.fx.util.*;
import org.cus.fx.util.mp3.MP3Util;

import java.util.logging.Logger;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class.toString());

    private AccountInterface accountInterface = FeignUtil.feign()
            .target(AccountInterface.class, new FeignRequest().URL());
    private ObjectMapper objectMapper = new ObjectMapper();
    private MP3Util mp3Util = new MP3Util();

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
    private Button res_res;
    @FXML
    private Button login_login;

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
            logger.info(new LoggerUtil(IndexController.class, "reigster", "跳转异常").toString());
            mp3Util.mp3("/mp3/error.mp3");
        }
    }

    @FXML
    private void register_data(ActionEvent event) {
        res_res.setDisable(true);
        AlertUtil alertUtil = new AlertUtil();
        try {
            String account = res_acc.getText();
            String pwd = res_pwd.getText();
            AccountModel model = new AccountModel();
            model.setUsername(account);
            model.setPassword(pwd);
            model.setTypes(1);
//            java转json
            String json = objectMapper.writeValueAsString(model);
            ResponseResult<String> register = accountInterface.register(json);
            if (register.isSuccess()) {
                res_res.setDisable(true);
                alertUtil.f_alert_informationDialog("提示", "成功");
                register_login(event);
            } else {
                alertUtil.f_alert_informationDialog("警告", register.getMessage());
                res_res.setDisable(false);
                mp3Util.mp3("/mp3/error.mp3");
            }
        } catch (FeignException f) {
            logger.info(new LoggerUtil(IndexController.class, "reigster_data", f.getMessage()).toString());
            alertUtil.f_alert_informationDialog("警告", f.getMessage());
            mp3Util.mp3("/mp3/error.mp3");
            res_res.setDisable(false);
        } catch (Exception e) {
            logger.info(new LoggerUtil(IndexController.class, "reigster_data", "注册失败").toString());
            alertUtil.f_alert_informationDialog("警告", "失败");
            mp3Util.mp3("/mp3/error.mp3");
            res_res.setDisable(false);
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
            mp3Util.mp3("/mp3/error.mp3");
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
        error.setText(null);
        error.setTextFill(Color.RED);
        login_login.setDisable(true);
        login_login.setText("O");
        String account = this.account.getText();
        String password = this.password.getText();
        if (account.trim().equals("") || password.trim().equals("")) {
            mp3Util.mp3("/mp3/error.mp3");
            error.setText("账户密码不能为空");
            login_login.setDisable(false);
            login_login.setText("登录");
        } else {
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Platform.runLater(() -> {
                        AccountModel model = new AccountModel();
                        model.setUsername(account);
                        model.setPassword(Base64Util.encode(password));
                        model.setTypes(1);
                        try {
                            String json = objectMapper.writeValueAsString(model);
                            ResponseResult<String> result = accountInterface.login(json);
                            if (result.isSuccess()) {
                                HomeController homeController = new HomeController();
                                homeController.init(result.getData());
                            } else {
                                mp3Util.mp3("/mp3/error.mp3");
                                logger.info(new LoggerUtil(IndexController.class, "login", result.getMessage()).toString());
                                error.setText(result.getMessage());
                                login_login.setDisable(false);
                                login_login.setText("登录");
                            }
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            mp3Util.mp3("/mp3/error.mp3");
                            logger.info(new LoggerUtil(IndexController.class, "login", "数据转换错误").toString());
                            error.setText("数据转换错误");
                            login_login.setDisable(false);
                            login_login.setText("登录");
                        } catch (FeignException e) {
                            e.printStackTrace();
                            mp3Util.mp3("/mp3/error.mp3");
                            logger.info(new LoggerUtil(IndexController.class, "login", "远程服务器错误").toString());
                            error.setText("远程服务器错误");
                            login_login.setDisable(false);
                            login_login.setText("登录");
                        } catch (Exception e) {
                            e.printStackTrace();
                            mp3Util.mp3("/mp3/error.mp3");
                            logger.info(new LoggerUtil(IndexController.class, "login", "跳转错误").toString());
                            error.setText("跳转错误");
                            login_login.setDisable(false);
                            login_login.setText("登录");
                        }
                    });
                    return null;
                }
            };
            new Thread(task).start();
        }
    }
}
