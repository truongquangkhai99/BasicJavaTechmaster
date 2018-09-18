package com.JavaTechmaster.app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Hashtable;

public class SecondStage extends Stage {
    private Hashtable<String, String> parameters;

    private Scene scene;
    private VBox vbox = new VBox();

    private Label lblLoanContent = new Label();
    private Label lblCompanySizes = new Label();
    private Label lblMoney = new Label();
    private Label lblMonths = new Label();
    private Label lblEnsurance = new Label();

    SecondStage(double width, double height, Hashtable<String, String> parameters){
        super();
        this.parameters = parameters;
        lblLoanContent.setText(parameters.get("loanContent"));
        lblCompanySizes.setText(parameters.get("companySizes"));
        lblMoney.setText(parameters.get("money"));
        lblMonths.setText(parameters.get("months"));
        lblEnsurance.setText(parameters.get("ensurance"));

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(lblLoanContent,lblCompanySizes,lblMoney,lblMonths,lblEnsurance);
        scene = new Scene(vbox, width, height);
        this.setScene(scene);
    }
}
