package org.cus.fx.home.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.cus.fx.grzl.controller.GrzlController;
import org.cus.fx.spgl.controller.SpglController;
import org.cus.fx.util.AlertUtil;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class HomeController {

    static String username;

    @FXML
    private Pane bodys;

    public void init(String account) throws Exception {
        username = account;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home/home.fxml"));
//        获取stage
        ObservableList<Stage> stages = FXRobotHelper.getStages();
//        设置为新的内容窗口
        Stage primaryStage = stages.get(0);
        primaryStage.setTitle("欢迎来到后台管理");
        primaryStage.getScene().setRoot(root);
        primaryStage.getScene().getStylesheets().clear();
        primaryStage.getScene().getStylesheets().add(getClass().getResource("/css/home/home.css").toExternalForm());
        primaryStage.show();
    }

    //    退出
    @FXML
    private void logout() {
        //        获取stage
        AlertUtil util = new AlertUtil();
        boolean b = util.f_alert_confirmDialog("警告", "是否确定退出");
        if (b) {
            ObservableList<Stage> stages = FXRobotHelper.getStages();
            stages.get(0).close();
        }
    }

    @FXML
    private void grzl() {
        GrzlController.grzl(bodys);
    }

    @FXML
    private void spgl() {
        new SpglController().spgl(bodys, 0);
    }

    @FXML
    private void ddgl() {
        new SpglController().spgl(bodys, 0);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HomeController.username = username;
    }
}
