package org.cus.fx.ewm.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.account.service.AccountService;
import org.cus.fx.account.service.AccountServiceImpl;
import org.cus.fx.home.controller.HomeController;
import org.cus.fx.util.Base64Util;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class EwmController {
    public static void ewm(Pane pane) {
        pane.getChildren().clear();
        ImageView image = new ImageView("/ewm/ewm.png");
        image.setFitHeight(200);
        image.setFitWidth(200);
        pane.getChildren().add(image);
    }
}
