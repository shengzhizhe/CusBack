package org.cus.fx.order.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import org.cus.fx.order.model.OrderModel;
import org.cus.fx.order.service.OrderService;
import org.cus.fx.order.service.OrderServiceImpl;
import org.cus.fx.order.service.OrderSpService;
import org.cus.fx.order.service.OrderSpServiceImpl;
import org.cus.fx.spgl.model.SpglModel;
import org.cus.fx.util.AlertUtil;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class OrderController {

    static Pane pane_lout;
    static String ddid;
    static TableView<SpglModel> tableView_body;

    public void ddgl(Pane pane, int page) {
        pane_lout = pane;
        pane.getChildren().clear();
        pane.setPrefWidth(USE_COMPUTED_SIZE);
        page = page > 0 ? page : 0;
        Button button4 = new Button(page + "");
        button4.setId("page");
        button4.setVisible(false);
        pane.getChildren().add(button4);

        Button button2 = new Button("上一页");
        button2.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) - 1);
        });
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(60);
        button3.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) + 1);
        });
        pane.getChildren().add(button3);

        OrderService orderService = new OrderServiceImpl();
        List<OrderModel> list = orderService.page(page, "0");
        ObservableList<OrderModel> data = FXCollections.observableArrayList(list);

//        声明table
        TableView<OrderModel> tableView = new TableView<>();
//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder();
        tableView.setEditable(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        tableView.setPrefWidth(bounds.getWidth() - 90);
        tableView.setPrefHeight(300);
        tableView.setLayoutY(20);

        TableColumn<OrderModel, String> column0 = new TableColumn<>("id");
        column0.setVisible(false);
        column0.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<OrderModel, String> column1 = new TableColumn<>("序号");
        column1.setSortable(false);
        column1.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        int rowIndex = this.getIndex() + 1;
                        this.setText(String.valueOf(rowIndex));
                        TableRow row = this.getTableRow();
                        if (row != null)
                            row.setOnMouseClicked((MouseEvent o) -> {
                                OrderModel item1 = (OrderModel) row.getItem();
                                query(item1.getUuid());
                            });
                    }
                }
            };
            return cell;
        });
        TableColumn<OrderModel, String> column5 = new TableColumn<>("送货地址");
        column5.setSortable(false);
        column5.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<OrderModel, String> column6 = new TableColumn<>("电话");
        column6.setSortable(false);
        column6.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<OrderModel, String> column7 = new TableColumn<>("订单编号");
        column7.setSortable(false);
        column7.setCellValueFactory(new PropertyValueFactory<>("ddbh"));
        TableColumn<OrderModel, String> column9 = new TableColumn<>("创建人");
        column9.setSortable(false);
        column9.setCellValueFactory(new PropertyValueFactory<>("account"));
        TableColumn column12 = new TableColumn("操作");
//        禁用排序
        column12.setSortable(false);
        column12.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("完成");
                        button.setOnAction(o -> {
                            new OrderController().update(o, this.getTableView().getItems().get(this.getIndex()));
                        });
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

//        加载数据
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column7, column9, column6, column5, column12);
        pane.getChildren().add(tableView);

        tableView_body = new TableView<>();
//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder();
        tableView_body.setEditable(true);
        tableView_body.setPrefWidth(bounds.getWidth() - 90);
        tableView_body.setPrefHeight(bounds.getHeight() - 325 - 50);
        tableView_body.setLayoutY(325);
        TableColumn<SpglModel, String> column2_1 = new TableColumn<>("id");
        column2_1.setVisible(false);
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_2 = new TableColumn<>("名称");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_3 = new TableColumn<>("单价");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_4 = new TableColumn<>("单位");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_5 = new TableColumn<>("规格");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_6 = new TableColumn<>("品牌");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_7 = new TableColumn<>("数量");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<SpglModel, String> column2_8 = new TableColumn<>("总价");
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        ObservableList<SpglModel> data2 = FXCollections.observableArrayList(new ArrayList<>());
        tableView_body.setItems(data2);
        tableView_body.getColumns().addAll(column2_1, column2_2, column2_3, column2_4, column2_5, column2_6, column2_7, column2_8);
        pane.getChildren().add(tableView_body);
    }

    private void update(ActionEvent event, OrderModel model) {
        OrderService orderService = new OrderServiceImpl();
        model.setType(1);
        int i = orderService.update(model);
        AlertUtil alertUtil = new AlertUtil();
        if (i > 0) {
            alertUtil.f_alert_informationDialog("通知", "成功");
            new OrderController().ddgl(pane_lout, 0);
        } else
            alertUtil.f_alert_informationDialog("警告", "失败");
    }

    private void query(String id) {
        OrderSpService orderSpService = new OrderSpServiceImpl();
        List<SpglModel> list = orderSpService.getByOrderId(id);
        ObservableList<SpglModel> data2 = FXCollections.observableArrayList(list);
        tableView_body.getItems().addAll(data2);
    }
}
