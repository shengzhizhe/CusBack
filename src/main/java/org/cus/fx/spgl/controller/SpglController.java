package org.cus.fx.spgl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RetryableException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.cus.fx.api.SpglInterface;
import org.cus.fx.api.UploadInterface;
import org.cus.fx.spgl.model.SpglModel;
import org.cus.fx.util.*;
import org.cus.fx.util.jdbc.Path;
import org.cus.fx.util.mp3.MP3Util;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SpglController {

    private static Logger logger = Logger.getLogger(SpglController.class.toString());
    private SpglInterface spglInterface = FeignUtil.feign()
            .target(SpglInterface.class, new FeignRequest().URL());
    private UploadInterface uploadInterface = FeignUtil.feign()
            .target(UploadInterface.class, new FeignRequest().URL());
    private ObjectMapper objectMapper = new ObjectMapper();
    private MP3Util mp3Util = new MP3Util();
    private AlertUtil alertUtil = new AlertUtil();

    static Pane pane_lout;
    static String spid;
    private static ObservableList<SpglModel> data = null;
    private static TableView<SpglModel> tableView = null;

    public void spgl(Pane pane, int page) {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        setPane_lout(pane);
        pane.getChildren().clear();

        page = page > 0 ? page : 1;
        Button button4 = new Button(page + "");
        button4.setId("page");
        button4.setVisible(false);
        pane.getChildren().add(button4);

        Button button = new Button("新增");
        button.setOnAction(o -> {
            this.add(o, pane);
        });
        button.getStyleClass().add("menus");
        pane.getChildren().add(button);

        Button button2 = new Button("上一页");
        button2.setLayoutX(45);
        button2.setOnAction(o -> {
            this.spgl(pane, Integer.parseInt(button4.getText()) - 1);
        });
        button2.getStyleClass().add("menus");
        pane.getChildren().add(button2);

        Button button3 = new Button("下一页");
        button3.setLayoutX(100);
        button3.setOnAction(o -> {
            this.spgl(pane, Integer.parseInt(button4.getText()) + 1);
        });
        button3.getStyleClass().add("menus");
        pane.getChildren().add(button3);

        Label label = new Label("当前页数:" + page);
        label.setLayoutX(bounds.getWidth() - 200);
        pane.getChildren().add(label);

//        可以替换默认的表格无内容提示信息
//        tableView.setPlaceholder(label2);
        tableView = new TableView<>();
        tableView.setEditable(true);
        tableView.setPrefWidth(bounds.getWidth() - 90);
        tableView.setPrefHeight(bounds.getHeight() - 60);
        tableView.setLayoutY(20);

        TableColumn<SpglModel, String> column0 = new TableColumn<>("id");
        column0.setVisible(false);
        column0.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<SpglModel, String> column1 = new TableColumn<>("序号");
        column1.setSortable(false);
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
        column2.setSortable(false);
        column2.setCellValueFactory(new PropertyValueFactory<>("cname"));
        TableColumn<SpglModel, String> column3 = new TableColumn<>("价格");
        column3.setSortable(false);
        column3.setCellValueFactory(new PropertyValueFactory<>("jg"));
        TableColumn<SpglModel, String> column4 = new TableColumn<>("单位");
        column4.setSortable(false);
        column4.setCellValueFactory(new PropertyValueFactory<>("dw"));
        TableColumn<SpglModel, String> column5 = new TableColumn<>("规格");
        column5.setSortable(false);
        column5.setCellValueFactory(new PropertyValueFactory<>("ge"));
        TableColumn<SpglModel, String> column6 = new TableColumn<>("品牌");
        column6.setSortable(false);
        column6.setCellValueFactory(new PropertyValueFactory<>("pp"));
        TableColumn<SpglModel, String> column7 = new TableColumn<>("详情");
        column7.setSortable(false);
        column7.setCellValueFactory(new PropertyValueFactory<>("xq"));
        TableColumn<SpglModel, String> column8 = new TableColumn<>("数量");
        column8.setSortable(false);
        column8.setCellValueFactory(new PropertyValueFactory<>("sl"));
        TableColumn<SpglModel, String> column9 = new TableColumn<>("分类");
        column9.setSortable(false);
        column9.setCellValueFactory(new PropertyValueFactory<>("lm"));
        TableColumn<SpglModel, String> column10 = new TableColumn<>("是否下架");
        column10.setSortable(false);
        column10.setCellValueFactory(new PropertyValueFactory<>("sxj_string"));

        TableColumn column11 = new TableColumn("操作");
//        禁用排序
        column11.setSortable(false);
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
                        button.getStyleClass().add("menus");
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });
        TableColumn column12 = new TableColumn("操作");
//        禁用排序
        column12.setSortable(false);
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
                        button.getStyleClass().add("menus");
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });
//        加载数据
        data = FXCollections.observableArrayList();
        tableView.setItems(data);
        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12);
        pane.getChildren().add(tableView);

        datas(page);
    }

    private void datas(int page) {
        data.clear();
        ResponseResult<String> result = spglInterface.page(page, 15, StaticToken.getToken());
        if (result.isSuccess()) {
            String json = result.getData().substring(0, result.getData().lastIndexOf("]") + 1);
            try {
                List<SpglModel> beanList = objectMapper.readValue(json, new TypeReference<List<SpglModel>>() {
                });
                data.addAll(beanList);
                String s = result.getData().substring(result.getData().lastIndexOf("]") + 1, result.getData().length());
                StaticToken.setToken(s);
            } catch (IOException e) {
                e.printStackTrace();
                mp3Util.mp3("/mp3/error.mp3");
                logger.info(new LoggerUtil(SpglController.class, "spgl", "数据转换错误").toString());
                alertUtil.f_alert_informationDialog("警告", "数据转换错误");
            } catch (Exception e) {
                e.printStackTrace();
                mp3Util.mp3("/mp3/error.mp3");
                logger.info(new LoggerUtil(SpglController.class, "spgl", "获取数据失败").toString());
                alertUtil.f_alert_informationDialog("警告", "获取数据失败");
            }
        } else {
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "spgl", result.getMessage()).toString());
            alertUtil.f_alert_informationDialog("警告", result.getMessage());
        }
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

        Button button2 = new Button();
        button2.setPrefWidth(70);
        button2.setPrefHeight(25);
        button2.setText("返回");
        button2.setOnAction(o -> {
            this.spgl(pane, 0);
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
        try {
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
            Button button = (Button) k3.getChildren().get(4);
            model.setZt(button.getId());
        } catch (Exception e) {
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "数据转换错误").toString());
            alertUtil.f_alert_informationDialog("警告", "数据转换错误");
            return 0;
        }
        try {
            String json = objectMapper.writeValueAsString(model);
            ResponseResult<String> result = spglInterface.add(json + StaticToken.getToken());
            if (result.isSuccess()) {
                String s = result.getData().substring(result.getData().lastIndexOf("}") + 1, result.getData().length());
                StaticToken.setToken(s);
                return 1;
            } else {
                mp3Util.mp3("/mp3/error.mp3");
                StaticToken.setToken(result.getData());
                alertUtil.f_alert_informationDialog("警告", result.getMessage());
                return 0;
            }
        } catch (RetryableException e) {
            e.printStackTrace();
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "远程服务器错误").toString());
            alertUtil.f_alert_informationDialog("警告", "远程服务器错误");
            return -1;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "数据转换错误").toString());
            alertUtil.f_alert_informationDialog("警告", "数据转换错误");
            return -1;
        }
    }

    private int del(ActionEvent event, SpglModel model) {
        ResponseResult<String> result = spglInterface.del(model.getUuid(), StaticToken.getToken());
        if (result.isSuccess()) {
            String s = result.getData().substring(result.getData().lastIndexOf("}") + 1, result.getData().length());
            StaticToken.setToken(s);
            return 1;
        } else {
            mp3Util.mp3("/mp3/error.mp3");
            StaticToken.setToken(result.getData());
            alertUtil.f_alert_informationDialog("警告", result.getMessage());
            return 0;
        }
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

        ImageView image = new ImageView();
        image.setFitHeight(80);
        image.setFitWidth(80);
        image.setImage(new Image("/image/tupian.jpg", true));
        Button button_file = new Button();
        button_file.setPrefWidth(80);
        button_file.setPrefHeight(20);
        button_file.setText("上传图片");
        button_file.setOnAction(o -> {
            try {
                String s = this.addImg();
                button_file.setId(s);
                image.setImage(new Image("file:" + s, true));
            } catch (Exception e) {
                mp3Util.mp3("/mp3/error.mp3");
                AlertUtil alertUtil = new AlertUtil();
                alertUtil.f_alert_informationDialog("警告", "失败");
            }
        });
        hBox.getChildren().addAll(button_file, image);

        Button button = new Button();
        button.setPrefWidth(60);
        button.setPrefHeight(20);
        button.setText("确定");
        button.setOnAction(o -> {
            int i = this.save(o, vBox);
            AlertUtil alertUtil = new AlertUtil();
            if (i > 0) {
                alertUtil.f_alert_informationDialog("通知", "成功");
                this.spgl(pane_lout, 0);
            } else {
                mp3Util.mp3("/mp3/error.mp3");
                alertUtil.f_alert_informationDialog("警告", "失败");
            }
        });
        Button button2 = new Button();
        button2.setPrefWidth(60);
        button2.setPrefHeight(20);
        button2.setText("返回");
        button2.setOnAction(o -> {
            this.spgl(pane_lout, 0);
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
        list.add("商品名称]" + model.getCname());
        list.add("商品价格]" + model.getJg());
        list.add("商品单位]" + model.getDw());
        list.add("商品规格]" + model.getGe());
        lists.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("商品品牌]" + model.getPp());
        list2.add("商品详情]" + model.getXq());
        list2.add("商品数量]" + model.getSl());
        lists.add(list2);
        VBox vBox = update_h(lists, model);
        pane.getChildren().add(vBox);
    }

    private VBox update_h(List<List<String>> names, SpglModel model) {
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
        hBox.setPrefWidth(USE_COMPUTED_SIZE);
        hBox.setPrefHeight(20);
        Insets insets = new Insets(15, 0, 0, 0);
        hBox.setPadding(insets);

        Label label = new Label();
        label.setPrefWidth(60);
        label.setPrefHeight(20);
        label.setText("是否下架:");
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>(FXCollections.observableArrayList(
                "是", "否"));
        choiceBox1.setValue(model.getSxj() == 0 ? "否" : "是");
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

        String path = (model.getZt() != null && !model.getZt().trim().equals("")) ? "file:" + model.getZt() : "/image/tupian.jpg";
        ImageView image = new ImageView(path);
        image.setFitHeight(80);
        image.setFitWidth(80);
        Button button_file = new Button();
        button_file.setPrefWidth(80);
        button_file.setPrefHeight(20);
        button_file.setText("上传图片");
        button_file.setOnAction(o -> {
            try {
                String s = this.addImg();
                button_file.setId(s);
                image.setImage(new Image("file:" + s, true));
            } catch (Exception e) {
                mp3Util.mp3("/mp3/error.mp3");
                AlertUtil alertUtil = new AlertUtil();
                alertUtil.f_alert_informationDialog("警告", "失败");
            }
        });
        hBox.getChildren().addAll(button_file, image);

        Button button = new Button();
        button.setPrefWidth(60);
        button.setPrefHeight(20);
        button.setText("确定");
        button.setOnAction(o -> {
            int i = this.updateData(o, vBox);
            AlertUtil alertUtil = new AlertUtil();
            if (i > 0) {
                alertUtil.f_alert_informationDialog("通知", "成功");
                this.spgl(pane_lout, 0);
            } else {
                mp3Util.mp3("/mp3/error.mp3");
                alertUtil.f_alert_informationDialog("警告", "失败");
            }
        });
        Button button2 = new Button();
        button2.setPrefWidth(60);
        button2.setPrefHeight(20);
        button2.setText("返回");
        button2.setOnAction(o -> {
            this.spgl(pane_lout, 0);
        });
        hBox.getChildren().addAll(button, button2);

        vBox.getChildren().addAll(hBox);
        return vBox;
    }

    private int updateData(ActionEvent event, VBox vBox) {
        SpglModel model = new SpglModel();
        try {
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
            Button button = (Button) k3.getChildren().get(4);
            model.setZt(button.getId());
        } catch (Exception e) {
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "数据转换错误").toString());
            alertUtil.f_alert_informationDialog("警告", "数据转换错误");
            return 0;
        }
        try {
            String json = objectMapper.writeValueAsString(model);
            ResponseResult<String> result = spglInterface.update(json + StaticToken.getToken());
            if (result.isSuccess()) {
                String s = result.getData().substring(result.getData().lastIndexOf("}") + 1, result.getData().length());
                StaticToken.setToken(s);
                return 1;
            } else {
                mp3Util.mp3("/mp3/error.mp3");
                StaticToken.setToken(result.getData());
                alertUtil.f_alert_informationDialog("警告", result.getMessage());
                return 0;
            }
        } catch (RetryableException e) {
            e.printStackTrace();
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "远程服务器错误").toString());
            alertUtil.f_alert_informationDialog("警告", "远程服务器错误");
            return -1;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            mp3Util.mp3("/mp3/error.mp3");
            logger.info(new LoggerUtil(SpglController.class, "login", "数据转换错误").toString());
            alertUtil.f_alert_informationDialog("警告", "数据转换错误");
            return -1;
        }
    }

    private String addImg() throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择文件");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file == null)
                return "";
            String urlStr = "http://localhost:9002/api/upload/upload";
            Map<String, String> fileMap = new HashMap<String, String>();
            String fileName = file.getName();
            fileMap.put("fileName", file.getPath());
            String contentType = "";//image/png
            String token = StaticToken.getToken();
            Map<String, String> textMap = new HashMap<String, String>();
            //可以设置多个input的name，value
            textMap.put("token", token);
            String s = formUpload(urlStr,textMap, fileMap, contentType);
            String res = s.split("\",\"code")[0];
            s = res.substring(res.lastIndexOf("}") + 1, res.length());
            StaticToken.setToken(s);
            // 打开输入流
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            fis = new FileInputStream(file);
            // 打开输出流
            String path = new Path().path() + "/img/" + GetUuid.getUUID() + "." + suffix;
            fos = new FileOutputStream(path);
            // 读取和写入信息
            int len = 0;
            // 创建一个字节数组，当做缓冲区
            byte[] b = new byte[1024];
            while ((len = fis.read(b)) != -1) {
                fos.write(b);
            }
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "异常";
    }

    /**
     * 上传图片
     * @param urlStr
     * @param fileMap
     * @param contentType 没有传入文件类型默认采用application/octet-stream
     * contentType非空采用filename匹配默认的图片类型
     * @return 返回response数据
     */
    @SuppressWarnings("rawtypes")
    public static String formUpload(String urlStr,Map<String, String> textMap, Map<String, String> fileMap,String contentType) {
        String res = "";
        HttpURLConnection conn = null;
        // boundary就是request头和上传文件内容的分隔符
        String BOUNDARY = "---------------------------123821742118716";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY)
                            .append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\""
                            + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }
            // file
            if (fileMap != null) {
                Iterator iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();

                    //没有传入文件类型，同时根据文件获取不到类型，默认采用application/octet-stream
                    contentType = new MimetypesFileTypeMap().getContentType(file);
                    //contentType非空采用filename匹配默认的图片类型
                    if(!"".equals(contentType)){
                        if (filename.endsWith(".png")) {
                            contentType = "image/png";
                        }else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".jpe")) {
                            contentType = "image/jpeg";
                        }else if (filename.endsWith(".gif")) {
                            contentType = "image/gif";
                        }else if (filename.endsWith(".ico")) {
                            contentType = "image/image/x-icon";
                        }
                    }
                    if (contentType == null || "".equals(contentType)) {
                        contentType = "application/octet-stream";
                    }
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY)
                            .append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\""
                            + inputName + "\"; filename=\"" + filename
                            + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(
                            new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            res = res.split("\",\"code")[0];
            String s = res.substring(res.lastIndexOf("}") + 1, res.length());
            StaticToken.setToken(s);
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

    public static Pane getPane_lout() {
        return pane_lout;
    }

    public static void setPane_lout(Pane pane_lout) {
        SpglController.pane_lout = pane_lout;
    }

    public static String getSpid() {
        return spid;
    }

    public static void setSpid(String spid) {
        SpglController.spid = spid;
    }
}
