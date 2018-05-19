package org.cus.fx.ewm.controller;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class EwmController {
    public static void ewm(Pane pane) {
        try {
            InputStream is = EwmController.class.getClassLoader().getResourceAsStream("ewm.properties");
            Properties properties = new Properties();
            properties.load(is);
            String ewm_path = properties.getProperty("ewm_path");
            String path = ewm_path;
            pane.getChildren().clear();
            ImageView image = new ImageView(path);
            image.setFitHeight(200);
            image.setFitWidth(200);
            pane.getChildren().add(image);
        } catch (Exception e) {
            Label label = new Label("文件读取错误");
            pane.getChildren().add(label);

        }
    }
}
