package com.JavaTechmaster.app;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty yearOfProduction;
    private final SimpleStringProperty description;
    private final SimpleStringProperty status;//available, unavailable

    //constructor
    public Product(String name, Integer yearOfProduction, String description, String status) {
        this.name = new SimpleStringProperty(name);
        this.yearOfProduction = new SimpleIntegerProperty(yearOfProduction);
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleStringProperty(status);
    }
    //setter
    public void setName(String name) {
        this.name.set(name);
    }
    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction.set(yearOfProduction);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    //getter
    public String getName() {
        return this.name.get();
    }
    public Integer getYearOfProduction() {
        return this.yearOfProduction.get();
    }

    public String getDescription() {
        return this.description.get();
    }

    public String getStatus() {
        return this.status.get();
    }
}
