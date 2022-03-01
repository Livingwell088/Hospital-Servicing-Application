package edu.wpi.cs3733.c22.teamB.controllers;

import edu.wpi.cs3733.c22.teamB.Bapp;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class AbsPage implements IPage {
    @FXML
    Pane anchorPane;

    @FXML
    Pane contentPane;

    public void initResize() {

        //contentPane.setLayoutX(Bapp.getPrimaryStage().getWidth()/4);
        //contentPane.setLayoutY(Bapp.getPrimaryStage().getHeight()/6);
        anchorPane.setPrefWidth(Bapp.getPrimaryStage().getWidth() - AnchorHomeController.curAnchorHomeController.sidebar.getWidth());
        anchorPane.setPrefHeight(Bapp.getPrimaryStage().getHeight() - AnchorHomeController.curAnchorHomeController.sidebar.getHeight());
        //(anchorpane-contentane)/2
        contentPane.setLayoutX((anchorPane.getWidth()-contentPane.getPrefWidth())/-2);
        contentPane.setLayoutY((anchorPane.getHeight()-contentPane.getPrefHeight())/-2);
    }

    public void resize() {
        Bapp.getPrimaryStage().heightProperty().addListener((observable)-> {
            //contentPane.setLayoutX(Bapp.getPrimaryStage().getWidth()/4);
            //contentPane.setLayoutY(Bapp.getPrimaryStage().getHeight()/6);
            anchorPane.setPrefWidth(Bapp.getPrimaryStage().getWidth() - AnchorHomeController.curAnchorHomeController.sidebar.getWidth());
            anchorPane.setPrefHeight(Bapp.getPrimaryStage().getHeight() - AnchorHomeController.curAnchorHomeController.sidebar.getHeight());
            //(anchorpane-contentane)/2
           contentPane.setLayoutY((anchorPane.getPrefHeight()-contentPane.getPrefHeight())/-2);
        });

        Bapp.getPrimaryStage().widthProperty().addListener((observable)-> {
            //contentPane.setLayoutX(Bapp.getPrimaryStage().getWidth()/4);
            //contentPane.setLayoutY(Bapp.getPrimaryStage().getHeight()/6);
            anchorPane.setPrefWidth(Bapp.getPrimaryStage().getWidth() - AnchorHomeController.curAnchorHomeController.sidebar.getWidth());
            anchorPane.setPrefHeight(Bapp.getPrimaryStage().getHeight() - AnchorHomeController.curAnchorHomeController.sidebar.getHeight());
            //(anchorpane-contentane)/2
            contentPane.setLayoutX((anchorPane.getPrefWidth()-contentPane.getPrefWidth())/2);
        });
    }
    }



