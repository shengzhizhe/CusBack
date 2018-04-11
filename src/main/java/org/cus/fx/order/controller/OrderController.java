package org.cus.fx.order.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import org.cus.fx.order.model.OrderModel;
import org.cus.fx.order.service.OrderService;
import org.cus.fx.order.service.serviceImpl.OrderServiceImpl;

import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class OrderController {

    static Pane pane_lout;
    static String ddid;

    public void ddgl(Pane pane, int page) {
        pane_lout = pane;
        pane.getChildren().clear();

        page = page > 0 ? page : 0;
        Button button4 = new Button(page + "");
        button4.setId("page");
        button4.setVisible(false);
        pane.getChildren().add(button4);

        Button button = new Button("新增");
//        button.setOnAction(o -> {
//            new SpglController().add(o, pane);
//        });
        pane.getChildren().add(button);

        Button button2 = new Button("上一页");
        button2.setLayoutX(92);
        button2.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) - 1);
        });
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(144);
        button3.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) + 1);
        });
        pane.getChildren().add(button3);

        OrderService orderService = new OrderServiceImpl();
        List<OrderModel> list = orderService.page(page, null);
        ObservableList<OrderModel> data = FXCollections.observableArrayList(list);

//        声明table
        TableView<OrderModel> tableView = new TableView<>();
//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder();
        tableView.setEditable(true);
        tableView.setPrefWidth(USE_COMPUTED_SIZE);
        tableView.setPrefHeight(600);
        tableView.setLayoutY(20);

        TableColumn<OrderModel, String> column0 = new TableColumn<>("id");
        column0.setVisible(false);
        column0.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<OrderModel, String> column1 = new TableColumn<>("序号");
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
                    }
                }
            };
            return cell;
        });
        TableColumn<OrderModel, String> column2 = new TableColumn<>("名称");
//        指定当前列数据的标识，跟model属性保持一至
        column2.setCellValueFactory(new PropertyValueFactory<>("cname"));
        TableColumn<OrderModel, String> column3 = new TableColumn<>("价格");
        column3.setCellValueFactory(new PropertyValueFactory<>("jg"));
        TableColumn<OrderModel, String> column4 = new TableColumn<>("单位");
        column4.setCellValueFactory(new PropertyValueFactory<>("dw"));

        TableColumn<OrderModel, String> column5 = new TableColumn<>("规格");
        column5.setCellValueFactory(new PropertyValueFactory<>("ge"));
        TableColumn<OrderModel, String> column6 = new TableColumn<>("品牌");
        column6.setCellValueFactory(new PropertyValueFactory<>("pp"));
        TableColumn<OrderModel, String> column7 = new TableColumn<>("详情");
        column7.setCellValueFactory(new PropertyValueFactory<>("xq"));
        TableColumn<OrderModel, String> column8 = new TableColumn<>("数量");
        column8.setCellValueFactory(new PropertyValueFactory<>("sl"));
        TableColumn<OrderModel, String> column9 = new TableColumn<>("分类");
        column9.setCellValueFactory(new PropertyValueFactory<>("lm"));
        TableColumn<OrderModel, String> column10 = new TableColumn<>("是否下架");
        column10.setCellValueFactory(new PropertyValueFactory<>("sxj"));

        TableColumn column11 = new TableColumn("操作");
//        禁用排序
        column11.setSortable(true);
        column11.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("删除");
//                        button.setOnAction(o -> {
//                            AlertUtil alertUtil = new AlertUtil();
//                            boolean b = alertUtil.f_alert_confirmDialog("警告", "是否确定删除?");
//                            if (b) {
//                                int i = new SpglController().del(o, this.getTableView().getItems().get(this.getIndex()));
//                                if (i > 0)
//                                    alertUtil.f_alert_informationDialog("通知", "成功");
//                                else
//                                    alertUtil.f_alert_informationDialog("警告", "失败");
//                                new SpglController().spgl(pane, 0);
//                            }
//                        });
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });
        TableColumn column12 = new TableColumn("操作");
//        禁用排序
        column12.setSortable(true);
        column12.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("修改");
//                        button.setOnAction(o -> {
//                            new SpglController().update(o, pane_lout, this.getTableView().getItems().get(this.getIndex()));
//                        });
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

//        加载数据
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12);
        pane.getChildren().add(tableView);
    }
}
