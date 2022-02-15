package edu.wpi.cs3733.c22.teamB.controllers;

import com.jfoenix.controls.JFXComboBox;
import edu.wpi.cs3733.c22.teamB.entity.AbstractSR;
import edu.wpi.cs3733.c22.teamB.entity.ComputerServiceSR;
import edu.wpi.cs3733.c22.teamB.entity.DatabaseWrapper;
import edu.wpi.cs3733.c22.teamB.entity.SecuritySR;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SecuritySRController implements IController {
    @FXML private JFXComboBox<String> helpTypeField;

    private SecuritySR sr = null;

    public SecuritySRController() {}

    public SecuritySRController(SecuritySR sr) {
        this.sr = sr;
    }

    @Override
    public void submit() {

    }

    @Override
    public void submit(AbstractSR sr) {

        DatabaseWrapper dw = new DatabaseWrapper();
        dw.addSR(new SecuritySR(sr));

    }

    @Override
    public void clear() {
        helpTypeField.setValue(null);
    }


    @FXML public void initialize() {
        String st[] = {"Hardware", "Software"};
        helpTypeField.setItems(FXCollections.observableArrayList(st));

    }
}
