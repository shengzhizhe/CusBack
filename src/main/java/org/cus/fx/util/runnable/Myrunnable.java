package org.cus.fx.util.runnable;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
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
            System.out.println("执行线程");
//                Stage window = new Stage();
//                window.setTitle("title");
//                //modality要使用Modality.APPLICATION_MODEL
//                window.initModality(Modality.APPLICATION_MODAL);
//                window.setMinWidth(300);
//                window.setMinHeight(150);
//                window.setX(bounds.getWidth() - 250);
//                window.setY(bounds.getHeight() - 150);
//                Label label = new Label("您有订单未处理");
//                VBox layout = new VBox(10);
//                layout.getChildren().addAll(label);
//                layout.setAlignment(Pos.CENTER);
//                Scene scene = new Scene(layout);
//                window.setScene(scene);
//                window.show();
        }
        this.run();
    }
}
