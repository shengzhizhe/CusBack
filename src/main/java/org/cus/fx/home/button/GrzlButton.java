package org.cus.fx.home.button;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.cus.fx.api.util.ApiUtil;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class GrzlButton {
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
        if (text.equals("123")) {
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
