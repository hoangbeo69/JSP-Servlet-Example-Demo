package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.GenericDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T>{

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jspservletjdbc_demo";
            String user = "root";
            String password = "123456";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public <T1> List<T1> query(String sql) {
        return null;
    }
}
