package org.cus.fx.home.controller;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.cus.fx.grzl.controller.GrzlController;
import org.cus.fx.order.controller.OrderController;
import org.cus.fx.spgl.controller.SpglController;
import org.cus.fx.util.AlertUtil;

import static javafx.stage.StageStyle.UNDECORATED;

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
//        窗口最大化
//        primaryStage.setMaximized(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
//        以下设置不要重复设置
        //        禁止窗口缩放
//        primaryStage.setResizable(false);
//        设置窗口风格
//        1) DECORATED——白色背景，带有最小化/最大化/关闭等有操作系统平台装饰（ 默认设置）
//        2) UNDECORATED——白色背景，没有操作系统平台装饰
//        3) TRANSPARENT——透明背景，没有操作系统平台装饰
//        4) UTILITY——白色背景，只有关闭操作系统平台装饰
//        5) UNIFIED——有操作系统平台装饰，消除装饰和内容之间的边框，内容背景和边框背景一致，（但要视平台支持），可以通过javafx.application.Platform.isSupported(javafx.application.ConditionalFeature)判断
//        primaryStage.initStyle(UNDECORATED);
//        最小化，任务栏可见图标
//        primaryStage.setIconified(true);
//        始终显示在其他窗口之上
//        stage.setAlwaysOnTop(true);
//        显示
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

    /**
     * 个人资料
     */
    @FXML
    private void grzl() {
        GrzlController.grzl(bodys);
    }

    /**
     * 商品管理
     */
    @FXML
    private void spgl() {
        new SpglController().spgl(bodys, 0);
    }

    /**
     * 订单管理
     */
    @FXML
    private void ddgl() {
        new OrderController().ddgl(bodys, 0);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HomeController.username = username;
    }
}
