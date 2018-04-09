package org.cus.fx.home.button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.cus.fx.jsb.model.JsbModel;
import org.cus.fx.jsb.service.JsbService;
import org.cus.fx.jsb.service.JsbServiceImpl;
import org.cus.fx.util.AlertUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SpglButton {
    public void spgl(Pane pane,int page) {
        pane.getChildren().clear();

        page = page > 0 ? page : 0;
        Button button4 = new Button(page+"");
        button4.setId("page");
        button4.setVisible(false);
        pane.getChildren().add(button4);

        Button button = new Button("新增");
        button.setOnAction(o -> {
            new SpglButton().add(o, pane);
        });
        pane.getChildren().add(button);

        Button button2 = new Button("上一页");
        button2.setLayoutX(40);
        button2.setOnAction(o -> {
            new SpglButton().spgl(pane,Integer.parseInt(button4.getText())-1);
        });
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(92);
        button3.setOnAction(o -> {
            new SpglButton().spgl(pane,Integer.parseInt(button4.getText())+1);
        });
        pane.getChildren().add(button3);

        JsbService jsbService = new JsbServiceImpl();
        List<JsbModel> list = jsbService.get("",page);
        ObservableList<JsbModel> data = FXCollections.observableArrayList(list);

//        声明table
        TableView<JsbModel> tableView = new TableView<>();
//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder();
        tableView.setEditable(true);
        tableView.setPrefWidth(930);
        tableView.setPrefHeight(590);
        tableView.setLayoutY(20);

        TableColumn<JsbModel, String> column0 = new TableColumn<>("id");
        column0.setVisible(false);
        column0.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<JsbModel, String> column1 = new TableColumn<>("序号");
        column1.setCellFactory((col) -> {
            TableCell<JsbModel, String> cell = new TableCell<JsbModel, String>() {
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
        TableColumn<JsbModel, String> column2 = new TableColumn<>("日期");
//        指定当前列数据的标识，跟model属性保持一至
        column2.setCellValueFactory(new PropertyValueFactory<>("rq"));
        TableColumn<JsbModel, String> column3 = new TableColumn<>("标题");
        column3.setCellValueFactory(new PropertyValueFactory<>("titles"));
        TableColumn<JsbModel, String> column4 = new TableColumn<>("内容");
        column4.setCellValueFactory(new PropertyValueFactory<>("bodys"));
        TableColumn column5 = new TableColumn("操作");
//        禁用排序
        column5.setSortable(true);
        column5.setCellFactory((col) -> {
            TableCell<JsbModel, String> cell = new TableCell<JsbModel, String>() {
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
                                int i = new SpglButton().del(o, this.getTableView().getItems().get(this.getIndex()));
                                if (i > 0)
                                    alertUtil.f_alert_informationDialog("通知", "成功");
                                else
                                    alertUtil.f_alert_informationDialog("警告", "失败");
                                new SpglButton().spgl(pane,0);
                            }
                        });
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

//        加载数据
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        pane.getChildren().add(tableView);
    }

    private void add(ActionEvent event, Pane pane) {
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
        button.setOnAction(o -> {
            int i = new SpglButton().save(o, datePicker, textField2, textField3);
            AlertUtil alertUtil = new AlertUtil();
            if (i > 0) {
                alertUtil.f_alert_informationDialog("通知", "成功");
                new SpglButton().spgl(pane,0);
            } else
                alertUtil.f_alert_informationDialog("警告", "失败");
        });

        Button button2 = new Button();
        button2.setPrefWidth(70);
        button2.setPrefHeight(25);
        button2.setText("返回");
        button2.setOnAction(o -> {
            new SpglButton().spgl(pane,0);
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

    private int save(ActionEvent event, DatePicker datePicker, TextField textField2, TextField textField3) {
        JsbModel model = new JsbModel();
        model.setRq(datePicker.getValue().toString());
        model.setTitles(textField2.getText());
        model.setBodys(textField3.getText());
        JsbService jsbService = new JsbServiceImpl();
        return jsbService.add(model);
    }

    private int del(ActionEvent event, JsbModel model) {
        JsbService jsbService = new JsbServiceImpl();
        return jsbService.delete(model.getUuid());
    }
}
