package org.cus.fx.util.runnable;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.cus.fx.order.model.OrderModel;
import org.cus.fx.order.service.OrderService;
import org.cus.fx.order.service.OrderServiceImpl;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class Myrunnable implements Runnable {
//    /        线程
//    Myrunnable myrunnable = new Myrunnable();
//    Thread thread = new Thread(myrunnable);
//        thread.start();
//        thread.wait(5000);

    @Override
    public void run() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        OrderService orderService = new OrderServiceImpl();
        List<OrderModel> list = orderService.page(0, "0");
        if (list.size() > 0) {
//            ObservableList<Stage> stages = FXRobotHelper.getStages();
//            Stage window = stages.get(0);
//            Label label = new Label("您有订单未处理");
//            VBox layout = new VBox(10);
//            layout.getChildren().addAll(label);
//            layout.setAlignment(Pos.CENTER);
//            Scene scene = new Scene(layout);
//            window.setScene(scene);
//            window.show();

//            window.setTitle("title");
//            //modality要使用Modality.APPLICATION_MODEL
//            window.initModality(Modality.APPLICATION_MODAL);
//            window.setMinWidth(300);
//            window.setMinHeight(150);
//            window.setX(bounds.getWidth() - 250);
//            window.setY(bounds.getHeight() - 150);
//            Label label = new Label("您有订单未处理");
//            VBox layout = new VBox(10);
//            layout.getChildren().addAll(label);
//            layout.setAlignment(Pos.CENTER);
//            Scene scene = new Scene(layout);
//            window.setScene(scene);
//            window.show();
        }
        this.run();
    }
}
