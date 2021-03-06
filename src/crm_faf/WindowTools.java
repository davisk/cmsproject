/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm_faf;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class WindowTools extends ToolBar {
    private HBox buttonBar = new HBox(); 
    private Button widgetButton = new Button();
    StatusWidget widget;
    
    public WindowTools(){
        super();
        setup();
    }

    private void setup() {
        Image statusOk = new Image(getClass().getResourceAsStream("ok-icon.png"));
        widgetButton.setGraphic(new ImageView(statusOk));
        buttonBar.getChildren().add(widgetButton);
        widgetButton.setOnAction(activateWidget());
        this.getItems().add(buttonBar);
    }
    
    private void setWidgetStatusOk() {
        Image statusOk = new Image(getClass().getResourceAsStream("ok-icon.png"));
        widgetButton.setGraphic(new ImageView(statusOk));
    }
    
    private void setWidgetStatusNotOk() {
        Image statusBad = new Image(getClass().getResourceAsStream("Delete-icon.png"));
        widgetButton.setGraphic(new ImageView(statusBad));
    }
    
   
    
    private EventHandler<ActionEvent> activateWidget() {
        return (ActionEvent event) -> {
            Stage popup = new Stage();
            VBox comp = new VBox();
            StatusWidget widget = new StatusWidget();
        //    widget.setFeed("http://feeds.reuters.com/news/artsculture");
            comp.getChildren().add(widget.getTable());
            Scene popupScene = new Scene(comp, 300, 300);
            popup.setScene(popupScene);
            popup.setX(300);
            popup.setY(400);
        };
    }
}
