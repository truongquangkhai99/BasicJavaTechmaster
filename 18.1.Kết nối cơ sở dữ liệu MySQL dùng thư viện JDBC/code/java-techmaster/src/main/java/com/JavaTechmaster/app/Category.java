package com.JavaTechmaster.app;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Category {
	private final SimpleIntegerProperty categoryID;
    private final SimpleStringProperty categoryName;
    private final SimpleStringProperty description;
    //constructor
    public Category(Integer categoryID, String categoryName, String description) {
        this.categoryID = new SimpleIntegerProperty(categoryID);
        this.categoryName = new SimpleStringProperty(categoryName);
        this.description = new SimpleStringProperty(description);        
    }    
    //setter
    public void setYearOfProduction(Integer categoryID) {
        this.categoryID.set(categoryID);
    }

    public void setName(String categoryName) {
        this.categoryName.set(categoryName);
    }    

    public void setDescription(String description) {
        this.description.set(description);
    }
    //getter
    public Integer getCategoryID() {
        return this.categoryID.get();
    }
    public String getCategoryName() {
        return this.categoryName.get();
    }
    public String getDescription() {
        return this.description.get();
    }

}

