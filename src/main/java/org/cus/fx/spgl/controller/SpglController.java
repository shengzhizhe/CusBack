package org.cus.fx.spgl.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.cus.fx.spgl.model.SpglModel;
import org.cus.fx.spgl.service.SpglService;
import org.cus.fx.spgl.service.SpglServiceImpl;
import org.cus.fx.util.AlertUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SpglController {

    static Pane pane_lout;
    static String spid;

    public void spgl(Pane pane, int page) {
        pane_lout = pane;
        pane.getChildren().clear();

        page = page > 0 ? page : 0;
        Button button4 = new Button(page + "");
        button4.setId("page");
        button4.setVisible(false);
        pane.getChildren().add(button4);

        Button button = new Button("新增");
        button.setOnAction(o -> {
            new SpglController().add(o, pane);
        });
        pane.getChildren().add(button);

        Button button2 = new Button("上一页");
        button2.setLayoutX(92);
        button2.setOnAction(o -> {
            new SpglController().spgl(pane, Integer.parseInt(button4.getText()) - 1);
        });
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(144);
        button3.setOnAction(o -> {
            new SpglController().spgl(pane, Integer.parseInt(button4.getText()) + 1);
        });
        pane.getChildren().add(button3);

        SpglService jsbService = new SpglServiceImpl();
        List<SpglModel> list = jsbService.get("", page);
        ObservableList<SpglModel> data = FXCollections.observableArrayList(list);

//        声明table
        TableView<SpglModel> tableView = new TableView<>();
//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder();
        tableView.setEditable(true);
        tableView.setPrefWidth(USE_COMPUTED_SIZE);
        tableView.setPrefHeight(600);
        tableView.setLayoutY(20);

        TableColumn<SpglModel, String> column0 = new TableColumn<>("id");
        column0.setVisible(false);
        column0.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<SpglModel, String> column1 = new TableColumn<>("序号");
        column1.setCellFactory((col) -> {
            TableCell<SpglModel, String> cell = new TableCell<SpglModel, String>() {
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
        TableColumn<SpglModel, String> column2 = new TableColumn<>("名称");
//        指定当前列数据的标识，跟model属性保持一至
        column2.setCellValueFactory(new PropertyValueFactory<>("cname"));
        TableColumn<SpglModel, String> column3 = new TableColumn<>("价格");
        column3.setCellValueFactory(new PropertyValueFactory<>("jg"));
        TableColumn<SpglModel, String> column4 = new TableColumn<>("单位");
        column4.setCellValueFactory(new PropertyValueFactory<>("dw"));

        TableColumn<SpglModel, String> column5 = new TableColumn<>("规格");
        column5.setCellValueFactory(new PropertyValueFactory<>("ge"));
        TableColumn<SpglModel, String> column6 = new TableColumn<>("品牌");
        column6.setCellValueFactory(new PropertyValueFactory<>("pp"));
        TableColumn<SpglModel, String> column7 = new TableColumn<>("详情");
        column7.setCellValueFactory(new PropertyValueFactory<>("xq"));
        TableColumn<SpglModel, String> column8 = new TableColumn<>("数量");
        column8.setCellValueFactory(new PropertyValueFactory<>("sl"));
        TableColumn<SpglModel, String> column9 = new TableColumn<>("分类");
        column9.setCellValueFactory(new PropertyValueFactory<>("lm"));
        TableColumn<SpglModel, String> column10 = new TableColumn<>("是否下架");
        column10.setCellValueFactory(new PropertyValueFactory<>("sxj"));

        TableColumn column11 = new TableColumn("操作");
//        禁用排序
        column11.setSortable(true);
        column11.setCellFactory((col) -> {
            TableCell<SpglModel, String> cell = new TableCell<SpglModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("删除");
                        button.setOnAction(o -> {
                            AlertUtil alertUtil = new AlertUtil();
                            boolean b = alertUtil.f_alert_confirmDialog("警告", "是否确定删除?");
                            if (b) {
                                int i = new SpglController().del(o, this.getTableView().getItems().get(this.getIndex()));
                                if (i > 0)
                                    alertUtil.f_alert_informationDialog("通知", "成功");
                                else
                                    alertUtil.f_alert_informationDialog("警告", "失败");
                                new SpglController().spgl(pane, 0);
                            }
                        });
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
            TableCell<SpglModel, String> cell = new TableCell<SpglModel, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button button = new Button("修改");
                        button.setOnAction(o -> {
                            new SpglController().update(o, pane_lout, this.getTableView().getItems().get(this.getIndex()));
                        });
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

//        加载数据
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11,column12);
        pane.getChildren().add(tableView);
    }

    private void add2(ActionEvent event, Pane pane) {
        pane.getChildren().clear();

        Label label1 = new Label("日期");
        label1.setPrefWidth(35);
        label1.setPrefHeight(25);
        label1.setText("日期");
        DatePicker datePicker = new DatePicker();
        datePicker.setPrefWidth(140);
        datePicker.setPrefHeight(25);
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("YYYY-MM-dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        datePicker.setConverter(converter);
        datePicker.setPromptText("YYYY-MM-dd");
        HBox hBox1 = new HBox();
        hBox1.setPrefWidth(200);
        hBox1.setPrefHeight(50);
        hBox1.getChildren().addAll(label1, datePicker);

        Label label2 = new Label("标题");
        label2.setPrefWidth(35);
        label2.setPrefHeight(25);
        label2.setText("标题");
        TextField textField2 = new TextField();
        textField2.setPrefWidth(140);
        textField2.setPrefHeight(25);
        HBox hBox2 = new HBox();
        hBox2.setPrefWidth(200);
        hBox2.setPrefHeight(50);
        hBox2.getChildren().addAll(label2, textField2);

        Label label3 = new Label("内容");
        label3.setPrefWidth(35);
        label3.setPrefHeight(25);
        label3.setText("内容");
        TextField textField3 = new TextField();
        textField3.setPrefWidth(140);
        textField3.setPrefHeight(25);
        HBox hBox3 = new HBox();
        hBox3.setPrefWidth(200);
        hBox3.setPrefHeight(50);
        hBox3.getChildren().addAll(label3, textField3);

        Button button = new Button();
        button.setPrefWidth(70);
        button.setPrefHeight(25);
        button.setText("确定");
//        button.setOnAction(o -> {
//            int i = new SpglController().save(o, datePicker, textField2, textField3);
//            AlertUtil alertUtil = new AlertUtil();
//            if (i > 0) {
//                alertUtil.f_alert_informationDialog("通知", "成功");
//                new SpglController().spgl(pane, 0);
//            } else
//                alertUtil.f_alert_informationDialog("警告", "失败");
//        });

        Button button2 = new Button();
        button2.setPrefWidth(70);
        button2.setPrefHeight(25);
        button2.setText("返回");
        button2.setOnAction(o -> {
            new SpglController().spgl(pane, 0);
        });

        HBox hBox4 = new HBox();
        hBox4.setPrefWidth(200);
        hBox4.setPrefHeight(50);
        hBox4.getChildren().addAll(button, button2);

        VBox vBox = new VBox();
        vBox.setPrefWidth(200);
        vBox.setPrefHeight(200);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);

        pane.getChildren().add(vBox);
    }

    private void add(ActionEvent event, Pane pane) {
        pane.getChildren().clear();
        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("商品名称");
        list.add("商品价格");
        list.add("商品单位");
        list.add("商品规格");
        lists.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("商品品牌");
        list2.add("商品详情");
        list2.add("商品数量");
        lists.add(list2);

        VBox vBox = add_h(lists);
        pane.getChildren().add(vBox);
    }

    private int save(ActionEvent event, VBox vBox) {
        SpglModel model = new SpglModel();

        HBox k1 = (HBox) vBox.getChildren().get(0);
        TextField textField11 = (TextField) k1.getChildren().get(1);
        model.setCname(textField11.getText());
        TextField textField12 = (TextField) k1.getChildren().get(3);
        model.setJg(Double.parseDouble(textField12.getText()));
        TextField textField13 = (TextField) k1.getChildren().get(5);
        model.setDw(textField13.getText());
        TextField textField14 = (TextField) k1.getChildren().get(7);
        model.setGe(textField14.getText());

        HBox k2 = (HBox) vBox.getChildren().get(1);
        TextField textField21 = (TextField) k2.getChildren().get(1);
        model.setPp(textField21.getText());
        TextField textField22 = (TextField) k2.getChildren().get(3);
        model.setXq(textField22.getText());
        TextField textField23 = (TextField) k2.getChildren().get(5);
        model.setSl(Integer.parseInt(textField23.getText()));

        HBox k3 = (HBox) vBox.getChildren().get(2);
        ChoiceBox choiceBox1 = (ChoiceBox) k3.getChildren().get(1);
        String s1 = (String) choiceBox1.getValue();
        model.setSxj(s1.equals("否") ? 0 : 1);
        ChoiceBox choiceBox2 = (ChoiceBox) k3.getChildren().get(3);
        String s2 = (String) choiceBox2.getValue();
        model.setLm(s2);

        SpglService jsbService = new SpglServiceImpl();
        return jsbService.add(model);
    }

    private int del(ActionEvent event, SpglModel model) {
        SpglService jsbService = new SpglServiceImpl();
        return jsbService.delete(model.getUuid());
    }

    private VBox add_h(List<List<String>> names) {
        VBox vBox = new VBox();
        vBox.setPrefWidth(910);
        vBox.setPrefHeight(610);
        names.forEach(k -> {
            HBox hBox = new HBox();
            hBox.setPrefWidth(910);
            hBox.setPrefHeight(20);
            Insets insets = new Insets(15, 0, 0, 0);
            hBox.setPadding(insets);
            k.forEach(j -> {
                Label label = new Label();
                label.setPrefWidth(60);
                label.setPrefHeight(20);
                label.setText(j + ":");
                TextField textField = new TextField();
                textField.setPrefWidth(160);
                textField.setPrefHeight(20);
                textField.setId(j);
                hBox.getChildren().addAll(label, textField);
            });
            vBox.getChildren().add(hBox);
        });
        HBox hBox = new HBox();
        hBox.setPrefWidth(910);
        hBox.setPrefHeight(20);
        Insets insets = new Insets(15, 0, 0, 0);
        hBox.setPadding(insets);

        Label label = new Label();
        label.setPrefWidth(60);
        label.setPrefHeight(20);
        label.setText("是否下架:");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>(FXCollections.observableArrayList(
                "是", "否"));
        choiceBox1.setValue("否");
        choiceBox1.setPrefHeight(20);
        choiceBox1.setId("是否下架");
        hBox.getChildren().addAll(label, choiceBox1);

        Label label2 = new Label();
        label2.setPrefWidth(60);
        label2.setPrefHeight(20);
        label2.setText("商品分类:");
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>(FXCollections.observableArrayList(
                "生疏", "调料", "水产", "烟酒", "其它"));
        choiceBox2.setValue("其它");
        choiceBox2.setPrefHeight(20);
        choiceBox2.setId("商品分类");
        hBox.getChildren().addAll(label2, choiceBox2);

        Label label3 = new Label();
        label3.setPrefWidth(60);
        label3.setPrefHeight(20);
        label3.setText("商品图片:");
        ImageView image = new ImageView("/image/rw.jpg");
        image.setFitHeight(60);
        image.setFitWidth(60);
        hBox.getChildren().addAll(label3, image);

        Button button = new Button();
        button.setPrefWidth(60);
        button.setPrefHeight(20);
        button.setText("确定");
        button.setOnAction(o -> {
            int i = new SpglController().save(o, vBox);
            AlertUtil alertUtil = new AlertUtil();
            if (i > 0) {
                alertUtil.f_alert_informationDialog("通知", "成功");
                new SpglController().spgl(pane_lout, 0);
            } else
                alertUtil.f_alert_informationDialog("警告", "失败");
        });
        Button button2 = new Button();
        button2.setPrefWidth(60);
        button2.setPrefHeight(20);
        button2.setText("返回");
        button2.setOnAction(o -> {
            new SpglController().spgl(pane_lout, 0);
        });
        hBox.getChildren().addAll(button, button2);

        vBox.getChildren().addAll(hBox);
        return vBox;
    }

    private void update(ActionEvent event, Pane pane, SpglModel model) {
        pane.getChildren().clear();
        spid = model.getUuid();
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("商品名称]"+model.getCname());
        list.add("商品价格]"+model.getJg());
        list.add("商品单位]"+model.getDw());
        list.add("商品规格]"+model.getGe());
        lists.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("商品品牌]"+model.getPp());
        list2.add("商品详情]"+model.getXq());
        list2.add("商品数量]"+model.getSl());
        lists.add(list2);
        VBox vBox = update_h(lists,model);
        pane.getChildren().add(vBox);
    }

    private VBox update_h(List<List<String>> names,SpglModel model) {
        VBox vBox = new VBox();
        vBox.setPrefWidth(910);
        vBox.setPrefHeight(610);
        names.forEach(k -> {
            HBox hBox = new HBox();
            hBox.setPrefWidth(910);
            hBox.setPrefHeight(20);
            Insets insets = new Insets(15, 0, 0, 0);
            hBox.setPadding(insets);
            k.forEach((j) -> {
                Label label = new Label();
                label.setPrefWidth(60);
                label.setPrefHeight(20);
                label.setText(j.split("]")[0] + ":");
                TextField textField = new TextField();
                textField.setPrefWidth(160);
                textField.setPrefHeight(20);
                textField.setId(j);
                textField.setText(j.split("]")[1] == null ? "" : j.split("]")[1]);
                hBox.getChildren().addAll(label, textField);
            });
            vBox.getChildren().add(hBox);
        });
        HBox hBox = new HBox();
        hBox.setPrefWidth(910);
        hBox.setPrefHeight(20);
        Insets insets = new Insets(15, 0, 0, 0);
        hBox.setPadding(insets);

        Label label = new Label();
        label.setPrefWidth(60);
        label.setPrefHeight(20);
        label.setText("是否下架:");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>(FXCollections.observableArrayList(
                "是", "否"));
        choiceBox1.setValue(model.getSxj()==0 ? "否" : "是");
        choiceBox1.setPrefHeight(20);
        choiceBox1.setId("是否下架");
        hBox.getChildren().addAll(label, choiceBox1);

        Label label2 = new Label();
        label2.setPrefWidth(60);
        label2.setPrefHeight(20);
        label2.setText("商品分类:");
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>(FXCollections.observableArrayList(
                "生疏", "调料", "水产", "烟酒", "其它"));
        choiceBox2.setValue(model.getLm());
        choiceBox2.setPrefHeight(20);
        choiceBox2.setId("商品分类");
        hBox.getChildren().addAll(label2, choiceBox2);

        Label label3 = new Label();
        label3.setPrefWidth(60);
        label3.setPrefHeight(20);
        label3.setText("商品图片:");
        ImageView image = new ImageView("/image/rw.jpg");
        image.setFitHeight(60);
        image.setFitWidth(60);
        hBox.getChildren().addAll(label3, image);

        Button button = new Button();
        button.setPrefWidth(60);
        button.setPrefHeight(20);
        button.setText("确定");
        button.setOnAction(o -> {
            int i = new SpglController().updateData(o, vBox);
            AlertUtil alertUtil = new AlertUtil();
            if (i > 0) {
                alertUtil.f_alert_informationDialog("通知", "成功");
                new SpglController().spgl(pane_lout, 0);
            } else
                alertUtil.f_alert_informationDialog("警告", "失败");
        });
        Button button2 = new Button();
        button2.setPrefWidth(60);
        button2.setPrefHeight(20);
        button2.setText("返回");
        button2.setOnAction(o -> {
            new SpglController().spgl(pane_lout, 0);
        });
        hBox.getChildren().addAll(button, button2);

        vBox.getChildren().addAll(hBox);
        return vBox;
    }

    private int updateData(ActionEvent event, VBox vBox) {
        SpglModel model = new SpglModel();
        model.setUuid(spid);
        HBox k1 = (HBox) vBox.getChildren().get(0);
        TextField textField11 = (TextField) k1.getChildren().get(1);
        model.setCname(textField11.getText());
        TextField textField12 = (TextField) k1.getChildren().get(3);
        model.setJg(Double.parseDouble(textField12.getText()));
        TextField textField13 = (TextField) k1.getChildren().get(5);
        model.setDw(textField13.getText());
        TextField textField14 = (TextField) k1.getChildren().get(7);
        model.setGe(textField14.getText());

        HBox k2 = (HBox) vBox.getChildren().get(1);
        TextField textField21 = (TextField) k2.getChildren().get(1);
        model.setPp(textField21.getText());
        TextField textField22 = (TextField) k2.getChildren().get(3);
        model.setXq(textField22.getText());
        TextField textField23 = (TextField) k2.getChildren().get(5);
        model.setSl(Integer.parseInt(textField23.getText()));

        HBox k3 = (HBox) vBox.getChildren().get(2);
        ChoiceBox choiceBox1 = (ChoiceBox) k3.getChildren().get(1);
        String s1 = (String) choiceBox1.getValue();
        model.setSxj(s1.equals("否") ? 0 : 1);
        ChoiceBox choiceBox2 = (ChoiceBox) k3.getChildren().get(3);
        String s2 = (String) choiceBox2.getValue();
        model.setLm(s2);

        SpglService jsbService = new SpglServiceImpl();
        return jsbService.update(model);
    }
}
