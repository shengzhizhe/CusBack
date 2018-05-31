package org.cus.fx.order.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import org.cus.fx.api.OrderInterface;
import org.cus.fx.order.model.OrderModel;
import org.cus.fx.order.model.OrderSpModel;
import org.cus.fx.spgl.controller.SpglController;
import org.cus.fx.util.*;
import org.cus.fx.util.mp3.MP3Util;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class OrderController {

    static Pane pane_lout;
    static int pageNow;
    static int zt2;
    static int lxqf2;

    private boolean boo_order = true;
    private static Logger logger = Logger.getLogger(SpglController.class.toString());
    private OrderInterface orderInterface = FeignUtil.feign()
            .target(OrderInterface.class, new FeignRequest().URL());
    private ObjectMapper objectMapper = new ObjectMapper();
    private MP3Util mp3Util = new MP3Util();
    private AlertUtil alertUtil = new AlertUtil();

    static TableView<OrderSpModel> tableView_body = null;
    ObservableList<OrderModel> data = null;
    ObservableList<OrderSpModel> data2 = null;

    public void ddgl(Pane pane, int page, int zt, int lxqf) {
        setPane_lout(pane);
        setPageNow(page < 1 ? 1 : page);
        setZt2(zt);
        setLxqf2(lxqf);
        pane.getChildren().clear();
        pane.setPrefWidth(USE_COMPUTED_SIZE);
        page = page > 0 ? page : 0;
        Button button4 = new Button(page + "");
        button4.setId("page");
        button4.setVisible(false);
        button4.getStyleClass().add("menus");
        pane.getChildren().add(button4);

        Button button2 = new Button("上一页");
        button2.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) - 1, zt, lxqf);
        });
        button2.getStyleClass().add("menus");
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(55);
        button3.setOnAction(o -> {
            new OrderController().ddgl(pane, Integer.parseInt(button4.getText()) + 1, zt, lxqf);
        });
        button3.getStyleClass().add("menus");
        pane.getChildren().add(button3);

        Button button4_1 = new Button("已完成订单");
        button4_1.setLayoutX(110);
        button4_1.setOnAction(o -> {
            new OrderController().ddgl(pane, 0, 1, lxqf);
        });
        button4_1.getStyleClass().add("menus");
        if (lxqf == 1)
            pane.getChildren().add(button4_1);

        Button button4_2 = new Button("已关闭订单");
        button4_2.setLayoutX(190);
        button4_2.setOnAction(o -> {
            new OrderController().ddgl(pane, 0, 2, lxqf);
        });
        button4_2.getStyleClass().add("menus");
        if (lxqf == 1)
            pane.getChildren().add(button4_2);

        data = FXCollections.observableArrayList();
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
        if (zt != 0)
            column12.setVisible(false);
        column12.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        AlertUtil alertUtil = new AlertUtil();
                        if (lxqf == 0) {
                            Button button = new Button("完成");
                            button.setOnAction(o -> {
                                boolean b = alertUtil.f_alert_confirmDialog("警告", "是否确定完成?");
                                if (b) {
                                    update(o, this.getTableView().getItems().get(this.getIndex()));
                                }
                            });
                            button.getStyleClass().add("menus");
                            this.setGraphic(button);
                        }
                    }
                }
            };
            return cell;
        });

        TableColumn column13 = new TableColumn("操作");
//        禁用排序
        column13.setSortable(false);
        if (zt != 0)
            column13.setVisible(false);
        column13.setCellFactory((col) -> {
            TableCell<OrderModel, String> cell = new TableCell<OrderModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        AlertUtil alertUtil = new AlertUtil();
                        if (lxqf == 0) {
                            Button button = new Button("关闭");
                            button.getStyleClass().add("menus");
                            button.setOnAction(o -> {
                                boolean b = alertUtil.f_alert_confirmDialog("警告", "是否确定关闭?关闭订单后将无法对其进行任何操作");
                                if (b)
                                    del(this.getTableView().getItems().get(this.getIndex()).getUuid());
                            });
                            this.setGraphic(button);
                        }
                    }
                }
            };
            return cell;
        });

//        加载数据
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column7, column9, column6, column5, column12, column13);
        pane.getChildren().add(tableView);

        tableView_body = new TableView<>();
//        可以替换默认的表格无内容提示信息
        Label label = new Label("此订单没有查询到商品");
        tableView_body.setPlaceholder(label);
        tableView_body.setEditable(true);
        tableView_body.setPrefWidth(bounds.getWidth() - 90);
        tableView_body.setPrefHeight(bounds.getHeight() - 325 - 50);
        tableView_body.setLayoutY(325);
        TableColumn<OrderSpModel, String> column2_1 = new TableColumn<>("id");
        column2_1.setVisible(false);
        column2_1.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        TableColumn<OrderSpModel, String> column2_0 = new TableColumn<>("序号");
        column2_0.setSortable(false);
        column2_0.setCellFactory((col) -> {
            TableCell<OrderSpModel, String> cell = new TableCell<OrderSpModel, String>() {
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
        TableColumn<OrderSpModel, String> column2_2 = new TableColumn<>("名称");
        column2_2.setCellValueFactory(new PropertyValueFactory<>("spid"));
        TableColumn<OrderSpModel, String> column2_3 = new TableColumn<>("单价");
        column2_3.setCellValueFactory(new PropertyValueFactory<>("spdj"));
        TableColumn<OrderSpModel, String> column2_4 = new TableColumn<>("单位");
        column2_4.setCellValueFactory(new PropertyValueFactory<>("dw"));
        TableColumn<OrderSpModel, String> column2_5 = new TableColumn<>("规格");
        column2_5.setCellValueFactory(new PropertyValueFactory<>("ge"));
        TableColumn<OrderSpModel, String> column2_6 = new TableColumn<>("品牌");
        column2_6.setCellValueFactory(new PropertyValueFactory<>("pp"));
        TableColumn<OrderSpModel, String> column2_7 = new TableColumn<>("数量");
        column2_7.setCellValueFactory(new PropertyValueFactory<>("spsl"));
        TableColumn<OrderSpModel, String> column2_8 = new TableColumn<>("总价");
        column2_8.setCellValueFactory(new PropertyValueFactory<>("spzj"));
        data2 = FXCollections.observableArrayList();
        tableView_body.setItems(data2);
        tableView_body.getColumns().addAll(column2_1, column2_0, column2_2, column2_3, column2_4, column2_5, column2_6, column2_7);
        pane.getChildren().add(tableView_body);
//        获取数据
        pageData(zt2);
//        sssx();
    }

    private void update(ActionEvent event, OrderModel model) {
        try {
            ResponseResult<String> result = orderInterface.update(model.getUuid(), 1, StaticToken.getToken());
            if (result.isSuccess()) {
                String s = result.getData().substring(result.getData().lastIndexOf("}") + 1, result.getData().length());
                StaticToken.setToken(s);
                ddgl(getPane_lout(), pageNow, zt2, lxqf2);
            } else {
                StaticToken.setToken(result.getData());
                mp3Util.mp3("/mp3/error.mp3");
                logger.info(new LoggerUtil(OrderController.class, "orderpage", result.getMessage()).toString());
                alertUtil.f_alert_informationDialog("警告", result.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(OrderController.class, "orderpage", "远程服务链接失败").toString());
            alertUtil.f_alert_informationDialog("警告", "远程服务链接失败");
        }
    }

    private void query(String id) {
        data2.clear();
        try {
            ResponseResult<String> result = orderInterface.getSp(pageNow, 15, id, StaticToken.getToken());
//        更新订单列表
            if (result.isSuccess()) {
                String s = result.getData().substring(result.getData().lastIndexOf("]") + 1, result.getData().length());
                StaticToken.setToken(s);
                try {
                    String json = result.getData().substring(0, result.getData().lastIndexOf("]") + 1);
                    List<OrderSpModel> beanList = objectMapper.readValue(json, new TypeReference<List<OrderSpModel>>() {
                    });
                    data2.addAll(beanList);
                } catch (IOException e) {
                    e.printStackTrace();
                    mp3Util.mp3("/mp3/error.mp3");
                    logger.info(new LoggerUtil(OrderController.class, "query", "数据转换错误").toString());
                    alertUtil.f_alert_informationDialog("警告", "数据转换错误");
                } catch (Exception e) {
                    e.printStackTrace();
                    mp3Util.mp3("/mp3/error.mp3");
                    logger.info(new LoggerUtil(OrderController.class, "query", "获取数据失败").toString());
                    alertUtil.f_alert_informationDialog("警告", "获取数据失败");
                }
            } else {
                StaticToken.setToken(result.getData());
//                mp3Util.mp3("/mp3/error.mp3");
                logger.info(new LoggerUtil(OrderController.class, "query", result.getMessage()).toString());
                alertUtil.f_alert_informationDialog("警告", result.getMessage());
            }
        } catch (RuntimeException e) {
//            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(OrderController.class, "query", "服务器链接失败，请从新登录").toString());
            alertUtil.f_alert_informationDialog("警告", "服务器链接失败，请从新登录");
        }
    }

//    //实时刷新
//    public void sssx() {
//        Timer timer = new Timer();
//        if (zt2 == 0) {
//            if (boo_order) {
//                boo_order = false;
//                timer.schedule(
//                        new java.util.TimerTask() {
//                            public void run() {
//                                //        最新订单提醒
//                                ResponseResult<String> result = orderInterface.findByType(StaticToken.getToken());
//                                if (result.isSuccess()) {
//                                    mp3Util.mp3("/mp3/xddts.mp3");
//                                    pageData(0);
//                                }
//                            }
//                        }, 0, 30 * 1000);
//            }
//        } else
////            切换其它的时候用于终止定期时
//            timer.cancel();
//    }

    public void pageData(int z) {
        data.clear();
        try {
            ResponseResult<String> result = orderInterface.page(pageNow, 15, z, StaticToken.getToken());
//        更新订单列表
            if (result.isSuccess()) {
                String s = result.getData().substring(result.getData().lastIndexOf("]") + 1, result.getData().length());
                StaticToken.setToken(s);
                try {
                    String json = result.getData().substring(0, result.getData().lastIndexOf("]") + 1);
                    List<OrderModel> beanList = objectMapper.readValue(json, new TypeReference<List<OrderModel>>() {
                    });
                    data.addAll(beanList);
                } catch (IOException e) {
                    e.printStackTrace();
                    mp3Util.mp3("/mp3/error.mp3");
                    logger.info(new LoggerUtil(OrderController.class, "orderpage", "数据转换错误").toString());
                    alertUtil.f_alert_informationDialog("警告", "数据转换错误");
                } catch (Exception e) {
                    e.printStackTrace();
                    mp3Util.mp3("/mp3/error.mp3");
                    logger.info(new LoggerUtil(OrderController.class, "orderpage", "获取数据失败").toString());
                    alertUtil.f_alert_informationDialog("警告", "获取数据失败");
                }
            } else {
                StaticToken.setToken(result.getData());
//                mp3Util.mp3("/mp3/error.mp3");
                logger.info(new LoggerUtil(OrderController.class, "orderpage", result.getMessage()).toString());
//                alertUtil.f_alert_informationDialog("警告", result.getMessage());
            }
        } catch (RuntimeException e) {
//            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(OrderController.class, "orderpage", "订单刷新失败，请从新登录").toString());
            alertUtil.f_alert_informationDialog("警告", "订单刷新失败，请从新登录");
        } catch (Exception e) {
            logger.info(new LoggerUtil(OrderController.class, "orderpage", "订单刷新失败，其它错误").toString());
        }
    }

    //关闭订单
    private void del(String id) {
        ResponseResult<String> result = orderInterface.update(id, 2, StaticToken.getToken());
        if (result.isSuccess()) {
            String s = result.getData().substring(result.getData().lastIndexOf("}") + 1, result.getData().length());
            StaticToken.setToken(s);
            ddgl(getPane_lout(), pageNow, zt2, lxqf2);
        } else {
            StaticToken.setToken(result.getData());
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(OrderController.class, "orderpage", result.getMessage()).toString());
            alertUtil.f_alert_informationDialog("警告", result.getMessage());
        }
    }

    public static Pane getPane_lout() {
        return pane_lout;
    }

    public static void setPane_lout(Pane pane_lout) {
        OrderController.pane_lout = pane_lout;
    }

    public static int getPageNow() {
        return pageNow;
    }

    public static void setPageNow(int pageNow) {
        OrderController.pageNow = pageNow;
    }

    public static int getZt2() {
        return zt2;
    }

    public static void setZt2(int zt2) {
        OrderController.zt2 = zt2;
    }

    public static int getLxqf2() {
        return lxqf2;
    }

    public static void setLxqf2(int lxqf2) {
        OrderController.lxqf2 = lxqf2;
    }


    public ObservableList<OrderModel> getData() {
        return data;
    }

    public void setData(ObservableList<OrderModel> data) {
        this.data = data;
    }

}
