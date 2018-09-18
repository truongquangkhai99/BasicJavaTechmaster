/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Sử dụng GridPane-Bài toán tính lãi suất vay
 */
package com.JavaTechmaster.app;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.event.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Optional;

import javafx.scene.input.*;
import javafx.stage.WindowEvent;

public class App extends Application {
    private ObservableList<Product> products = FXCollections.observableArrayList(
            new Product("Apple Lightning to 3.5mm",
                    2014,
                    "Works with all devices that have a Lightning connector and support iOS 10 or later",
                    "available"),
            new Product("Apple Watch 42mm",
                    2015,
                    "Composite back, Splash and Water resistant in rain, exercising, etc (but not to be submerged in water, as it's not waterproof)",
                    "unavailable"),
            new Product("USB Cube Adapter 5W",
                    2013,
                    "Apple A1385 USB Cube Adapter 5W Wall Charger for iPod; iPad, iPhone 5/5c/5s/6/6s/7 Plus",
                    "available"),
            new Product("Anmii DC01 5-port",
                    2012,
                    "USB Charging Station,Anmii DC01 5-port(1 Type-C Port) Desktop Charger with Smart IC Technology",
                    "available"),
            new Product("Apple 13 Inch MacBook Air",
                    1017,
                    ".8GHz dual-core Intel Core i5 processor with Turbo Boost up to 2.9GHz, the MacBook Air gets the job done ultrafast no matter the task.",
                    "unavailable"),
            new Product("a8Miss Apple Watch Band",
                    2018,
                    "Apple Watch Band, Silicone Replacement Iwatch Bands Series 1, Series 2,Series 3 (42mm S/M, Mint Green)",
                    "available"),
            new Product("iPhone Charger Syncwire",
                    2016,
                    "Lightning Cable - [Apple MFi Certified] 3.3ft iPhone Cord for iPhone X, 8, 8 Plus, 7, 7 Plus, 6s, 6s Plus, 6, 6 Plus, SE, 5s, 5c, 5, iPad mini, iPad Air, iPad Pro, iPod - White",
                    "unavailable"),
            new Product("MKLG2AM/A Watch", 2016, "Apple MKLG2AM/A Watch 1M Magnetic Charging Cable, White","available"),
            new Product("Apple Watch Stand", 2014, "Works with all devices that have a Lightning connector and support iOS 10 or later","unavailable"),
            new Product("IQIYI Apple Watch Charger", 2015, "compatible with all 38mm & 42mm of the Apple Watch models,including Series 1, Series 2 and Series 3","available"),
            new Product("UGREEN Portable Wireless", 2014, "What You Get: 15 months manufacturer warranty and life-time service support; Apple MFi Certified Wireless Charger Power Bank for Apple","unavailable")
    );
    private Label lblTitle = new Label("TableView example");
    private TableView<Product> tableView = new TableView<Product>();
    //Columns
    private TableColumn columnName = new TableColumn("Name");
    private TableColumn columnYearOfProduction = new TableColumn("Year of production");
    private TableColumn columnDescription = new TableColumn("Description");
    private TableColumn columnStatus = new TableColumn("Status");
    //Contexmenu hiện ra khi bấm chuột phải
    private ContextMenu contextMenu = new ContextMenu();

    private Product selectedProduct;
    private MenuItem menuItemDelete;
    private MenuItem menuItemProperty;

    public static void main( String[] args ) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TableView of products example");
        columnName.setMinWidth(200);
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        columnYearOfProduction.setMinWidth(100);
        columnYearOfProduction.setCellValueFactory(new PropertyValueFactory<>("yearOfProduction"));

        columnDescription.setMinWidth(500);
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        columnStatus.setMinWidth(100);
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.setItems(products);
        tableView.getColumns().addAll(columnName,columnYearOfProduction,columnDescription,columnStatus);

        //How to click on "row" in TableView ?
        tableView.setRowFactory(tv -> {
            //This is an "anonymous function"
            final TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Product rowData = row.getItem();
                    if(event.getClickCount() == 2 && !row.isEmpty()) {
                        System.out.println("You clicked a row");
                        //Show a stage here
                        showDetailProduct(rowData, row);
                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        System.out.println("You right-clicked a row");
                        selectedProduct = row.getItem();
                        contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
                        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                showDetailProduct(rowData, row);
                            }
                        });
                    }
                }
            });
            return row;
        });
        //Contextmenu chứa nhiều menuItem
        menuItemDelete = new MenuItem("Delete");
        menuItemProperty = new MenuItem("Properties");
        contextMenu.getItems().addAll(menuItemDelete, menuItemProperty);

        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Optional<ButtonType> result = showAlert(
                        "Are you sure you want to delete "+selectedProduct.getName()+"?");
                if(result.get() == ButtonType.OK) {
                    //Delete ?
                    for(Iterator<Product> iterator = products.iterator(); iterator.hasNext();){
                        Product deletingProduct = iterator.next();
                        if(deletingProduct.equals(selectedProduct)) {
                            iterator.remove();
                        }
                    }
                }
            }
        });

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(lblTitle, tableView);
        lblTitle.setFont(new Font("Arial", 25));
        Scene scene = new Scene(vbox, 960, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Add an alert before delete
    private Optional<ButtonType> showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("JavaTechmaster");
        alert.setHeaderText("Warning !");
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();

        return result;
    }

    private void showDetailProduct(Product selectedProduct, TableRow<Product> row) {
        DetailProduct detailProduct = new DetailProduct(selectedProduct, "Detail product");
        detailProduct.initModality(Modality.APPLICATION_MODAL);
        detailProduct.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                //System.out.println("Detail product is hiding");
                Product changedProduct = detailProduct.getProduct();
                products.set(row.getIndex(), changedProduct);
            }
        });
        detailProduct.showAndWait();
    }
}
