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
        System.out.println("执行");
    }
}
