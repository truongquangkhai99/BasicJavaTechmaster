package com.JavaTechmaster.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailProduct extends Stage {
    private Product product;
    private Scene scene = new Scene(new Group(), 380,300);
    private GridPane grid = new GridPane();
    private Text scenetitle = new Text("");

    private Label lblName           = new Label("Product's name");
    private Label lblYearOfProduction   = new Label("Production year");
    private Label lblDescription        = new Label("Description");
    private Label lblStatus             = new Label("Status");

    private TextField txtName               = new TextField();
    private TextField txtYearOfProduction   = new TextField();
    private TextField txtDescription        = new TextField();
    ObservableList<String> statuses = FXCollections.observableArrayList("available", "unavailable");
    final ComboBox comboBoxStatus = new ComboBox(statuses);

    private Button btnOK      = new Button("OK");
    private Button btnCancel  = new Button("Cancel");
    public Product getProduct() {
        product.setName(txtName.getText());
        product.setYearOfProduction(Integer.valueOf(txtYearOfProduction.getText()));
        product.setDescription(txtDescription.getText());
        product.setStatus(comboBoxStatus.getValue().toString());
        return product;
    }
    private void fillData() {
        txtName.setText(product.getName());
        txtYearOfProduction.setText(String.valueOf(product.getYearOfProduction()));
        txtDescription.setText(product.getDescription());
        comboBoxStatus.setValue(product.getStatus());
    }
    private void layoutMyScene() {
        grid.add(lblName, 0, 1);
        grid.add(txtName, 1, 1);

        grid.add(lblYearOfProduction, 0, 2);
        grid.add(txtYearOfProduction, 1, 2);

        grid.add(lblDescription, 0, 3);
        grid.add(txtDescription, 1, 3);

        grid.add(lblStatus, 0, 4);
        grid.add(comboBoxStatus, 1, 4);

        HBox hbox2Buttons = new HBox(10);
        hbox2Buttons.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2Buttons.setSpacing(15);
        hbox2Buttons.getChildren().setAll(btnOK, btnCancel);
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeStage();
            }
        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Get original product
                fillData();
                closeStage();
            }
        });
        grid.add(hbox2Buttons,0, 5, 2,1);
    }
    private void closeStage() {
        this.close();
    }
    //constructor
    public DetailProduct(Product product, String sceneTitle) {
        super();
        this.product = product;
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        layoutMyScene();
        this.scenetitle.setText(sceneTitle);
        this.scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.scenetitle.setText(sceneTitle);
        grid.add(this.scenetitle, 0, 0, 2, 1);
        this.scene.setRoot(grid);
        this.setScene(this.scene);

        fillData();
    }
}
