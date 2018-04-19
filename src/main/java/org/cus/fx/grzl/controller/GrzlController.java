package org.cus.fx.grzl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.cus.fx.api.AccountInterface;
import org.cus.fx.order.controller.OrderController;
import org.cus.fx.util.*;
import org.cus.fx.util.mp3.MP3Util;

import java.util.logging.Logger;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class GrzlController {
    private static Logger logger = Logger.getLogger(GrzlController.class.toString());
    private AccountInterface accountInterface = FeignUtil.feign()
            .target(AccountInterface.class, new FeignRequest().URL());
    private ObjectMapper objectMapper = new ObjectMapper();
    private MP3Util mp3Util = new MP3Util();

    //    点击个人资料
    public static void grzl(Pane pane) {
        pane.getChildren().clear();
        HBox hBox = new HBox();
        ObservableList<Node> children = hBox.getChildren();
        Label label = new Label("修改密码:");
        children.add(label);
        TextField textField = new TextField();
        children.add(textField);
        Button button = new Button("确定");
        button.setOnAction(o -> {
            new GrzlController().updatePWD(o, textField);
        });
        children.add(button);
        pane.getChildren().add(hBox);
    }

    //    点击确定按钮
    private void updatePWD(ActionEvent event, TextField textField) {
        String text = textField.getText();
        AlertUtil alertUtil = new AlertUtil();
        text = Base64Util.encode(text);
        ResponseResult<String> result = accountInterface.updatePWD(text, StaticToken.getToken());
        if (result.isSuccess()) {
            logger.info(new LoggerUtil(OrderController.class, "updatePWD", "修改密码成功").toString());
            alertUtil.f_alert_informationDialog("提示", "修改密码成功");
////            自动注销
            ObservableList<Stage> stages = FXRobotHelper.getStages();
            stages.get(0).close();
        } else {
            StaticToken.setToken(result.getData());
            logger.info(new LoggerUtil(OrderController.class, "updatePWD", result.getMessage()).toString());
            alertUtil.f_alert_informationDialog("警告", result.getMessage());
        }
    }
}
