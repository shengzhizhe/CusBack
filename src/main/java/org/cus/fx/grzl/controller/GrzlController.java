package org.cus.fx.grzl.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.account.service.AccountService;
import org.cus.fx.account.service.AccountServiceImpl;
import org.cus.fx.util.Base64Util;
import org.cus.fx.util.StaticToken;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class GrzlController {
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
            updatePWD(o, textField);
        });
        children.add(button);
        pane.getChildren().add(hBox);
    }

    //    点击确定按钮
    private static void updatePWD(ActionEvent event, TextField textField) {
        String text = textField.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        AccountService accountService = new AccountServiceImpl();
        AccountModel model = new AccountModel();
        text = Base64Util.encode(text);
        model.setPassword(text);
        model.setUsername(new StaticToken().getToken());
        int i = accountService.update(model);
        if (i > 0) {
            Pane pane = (Pane) textField.getParent().getParent();
            pane.getChildren().clear();
            alert.setTitle("提示");
            alert.setContentText("修改密码成功");
            alert.show();
        } else {
            alert.setTitle("警告");
            alert.setContentText("修改密码失败");
            alert.show();
        }
    }
}
