package org.cus.fx.home.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.cus.fx.home.button.GrzlButton;
import org.cus.fx.home.button.SpglButton;
import org.cus.fx.util.AlertUtil;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class HomeController {

    @FXML
    private Pane bodys;

    public void init() throws Exception {
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
        GrzlButton.grzl(bodys);
    }

    @FXML
    private void spgl() {
        new SpglButton().spgl(bodys,0);
    }
}
