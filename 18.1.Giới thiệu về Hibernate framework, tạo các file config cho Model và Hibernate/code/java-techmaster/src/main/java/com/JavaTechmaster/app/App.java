/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.omg.CORBA.DATA_CONVERSION;

import java.util.Hashtable;
import java.util.Optional;

public class App extends Application {
    public static void main( String[] args ) {
        System.out.println("Connect SQL Database using Java");
        Application.launch(args);
    }
    private Label lblTitle = new Label("TableView example");
    private Button btnRefresh = new Button("Refresh");
    private Button btnAdd = new Button("Add new Category");
    private TableView<Category> tableView = new TableView<Category>();

    //Columns
    private TableColumn columnCategoryID = new TableColumn("category's ID");
    private TableColumn columnCategoryName = new TableColumn("category's Name");
    private TableColumn columnDescription = new TableColumn("Description");

    private Category selectedCategory;

    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem menuItemDelete = new MenuItem("Delete");;
    private MenuItem menuItemProperty = new MenuItem("Properties");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TableView of categories example");
        btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.getInstance().getAllCategories();
            }
        });

        columnCategoryID.setMinWidth(100);
        columnCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));

        columnCategoryName.setMinWidth(200);
        columnCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        columnDescription.setMinWidth(300);
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        tableView.getColumns().addAll(columnCategoryID,columnCategoryName,columnDescription);
        tableView.setItems(Database.getInstance().getAllCategories());
        tableView.setRowFactory(tv -> {
            final TableRow<Category> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    contextMenu.hide();
                    //Double click
                    if(event.getClickCount() == 2 && !row.isEmpty()) {
                        System.out.println("You double-clicked a row");
                        showDetailCategory(row.getItem());
                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        selectedCategory = row.getItem();
                        contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
                        System.out.println("You right-clicked a row");
                    }
                }
            });
            return row;
        });
        contextMenu.getItems().addAll(menuItemDelete, menuItemProperty);
        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You pressed: Properties of "
                        +selectedCategory.getCategoryName());
                showDetailCategory(selectedCategory);
            }
        });
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You pressed: Delete of "
                        +selectedCategory.getCategoryName());
                Database.getInstance().deleteACategory(selectedCategory.getCategoryID());
                Database.getInstance().getAllCategories();
            }
        });

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(lblTitle,btnRefresh, btnAdd,tableView);
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showDetailCategory(null);
            }
        });
        lblTitle.setFont(new Font("Arial", 25));
        Scene scene = new Scene(vbox, 600, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showDetailCategory(Category selectedCategory) {
        DetailCategory detailCategory = new DetailCategory(selectedCategory,
                "Detail category");
        detailCategory.initModality(Modality.APPLICATION_MODAL);
        detailCategory.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Detail category is hiding");
                Database.getInstance().getAllCategories();
            }
        });
        detailCategory.showAndWait();
    }

}
