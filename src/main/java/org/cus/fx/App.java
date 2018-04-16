package org.cus.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.stage.StageStyle.DECORATED;

/**
 *
 *
 */
public class App extends Application {
    /**
     * 窗口设置https://blog.csdn.net/alanzyy/article/details/49273781
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //设置窗口的图标.
        primaryStage.getIcons().add(new Image(getClass().getResource("/image/ico.jpg").toExternalForm()));
//        禁止窗口缩放
//        primaryStage.setResizable(false);
//        设置窗口风格
//        1) DECORATED——白色背景，带有最小化/最大化/关闭等有操作系统平台装饰（ 默认设置）
//        2) UNDECORATED——白色背景，没有操作系统平台装饰
//        3) TRANSPARENT——透明背景，没有操作系统平台装饰
//        4) UTILITY——白色背景，只有关闭操作系统平台装饰
//        5) UNIFIED——有操作系统平台装饰，消除装饰和内容之间的边框，内容背景和边框背景一致，（但要视平台支持），可以通过javafx.application.Platform.isSupported(javafx.application.ConditionalFeature)判断
        primaryStage.initStyle(DECORATED);
//        最小化，任务栏可见图标
//        primaryStage.setIconified(true);
//        始终显示在其他窗口之上
//        stage.setAlwaysOnTop(true);
        index(primaryStage);
    }

    public void index(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/index.fxml"));
        primaryStage.setTitle("后台管理");
        Scene scene = new Scene(root, 1000, 600);
//        加载外部css
        scene.getStylesheets().add(getClass().getResource("/css/index.css").toExternalForm());
        primaryStage.setScene(scene);
//        显示
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
