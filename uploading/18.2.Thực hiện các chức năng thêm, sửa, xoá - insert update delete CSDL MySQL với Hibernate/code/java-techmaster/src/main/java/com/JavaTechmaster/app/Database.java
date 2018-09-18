/**
 Khoá học Java cơ bản + nâng cao
 Author: Nguyễn Đức Hoàng, Techmaster Vietnam
 */
 
package com.JavaTechmaster.app;

import org.hibernate.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Database {
    //Singleton pattern
    private static Database instance;
    SessionFactory sessionFactory;

    public static Database getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Database();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            instance.sessionFactory =
                    new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Cannot setupHibernate.Error:"+e);
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return instance;
    }

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javatutorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250"; // set your own limit

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;
    private ObservableList<Category> categories = FXCollections.observableArrayList();


    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                properties = new Properties();
                properties.setProperty("user", USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("MaxPooledStatements", MAX_POOL);
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, properties);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Cannot connect MySQL DB. Error : "+e.toString());
            }
        }
        return connection;
    }
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //INSERT INTO Categories(CategoryID, CategoryName, Description) VALUES(150, "Hải sản","Đồ ăn hải sản, cá, rong biển");
    /*
    public ObservableList<Category> getAllCategories() {
        String sql = "SELECT * FROM Categories";
        categories.clear();
        try {
            Statement statement = this.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer categoryID = resultSet.getInt("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                String description = resultSet.getString("Description");
                Category category = new Category(categoryID, categoryName, description);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            System.out.println("Cannot get data from DB. Error : "+e.toString());
        } finally {
            this.disconnect();
            return categories;
        }
    }
    */
    public ObservableList<Category> getAllCategories() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        categories.clear();
        Query query = session.createQuery("from Category");
        List<Category> result = query.list();
        result.forEach(eachCategory->{
            categories.add(eachCategory);
        });
        session.getTransaction().commit();
        session.close();
        return categories;
    }
    /*
    public void addNewCategory(String categoryName, String description) {
        String sql = "INSERT INTO Categories values (default, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot insert data to DB. Error : "+e.toString());
        } finally {
            this.disconnect();
        }
    }
    */
    public void addNewCategory(String categoryName, String description) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Category newCategory = new Category();
        newCategory.setCategoryName(categoryName);
        newCategory.setDescription(description);
        session.save(newCategory);
        session.getTransaction().commit();
        session.close();
    }
    /*
    public void updateACategory(Integer categoryID,
                                String categoryName,
                                String description) {
        String sql = "UPDATE Categories SET " +
                "CategoryName = ?," +
                "Description = ? " +
                "WHERE CategoryID = ?";
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, categoryID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot update data in DB. Error : "+e.toString());
        } finally {
            this.disconnect();
        }
    }
    */
    public void updateACategory(Integer categoryID,
                                String categoryName,
                                String description) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Category where categoryID = :id");
        query.setParameter("id", categoryID);
        List<Category> result = query.list();
        if(result.size() > 0) {
            Category selectedCategory = result.get(0);
            selectedCategory.setCategoryName(categoryName);
            selectedCategory.setDescription(description);
        }
        session.getTransaction().commit();
        session.close();
    }
    /*
    public void deleteACategory(Integer categoryID) {
        deleteProducts(categoryID);
        String sql = "DELETE FROM Categories WHERE categoryID = ?";
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot delete data in DB. Error : "+e.toString());
        } finally {
            this.disconnect();
        }
    }*/
    public void deleteACategory(Integer categoryID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery( "from Category where categoryID = :id" );
        query.setParameter("id", categoryID);
        List<Category> result = query.list();
        result.forEach(category -> {
            session.delete(category);
        });
        session.getTransaction().commit();
        session.close();
    }
    //Xoá các bảng quan hệ "n" với Category
    public void deleteProducts(Integer categoryID) {
        String sql = "DELETE FROM Products WHERE categoryID = ?";
        try {
            PreparedStatement preparedStatement = this.connect().prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot delete data in DB. Error : "+e.toString());
        } finally {
            this.disconnect();
        }
    }

}
