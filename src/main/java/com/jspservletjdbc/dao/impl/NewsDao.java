package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.CategoryModel;
import com.jspservletjdbc.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao implements INewsDao {

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
    public List<NewsModel> findByCategoryId(Long categoryID) {
        List<NewsModel> results = new ArrayList<>();
        String sql = "Select * From news Where categoryid = ?";
        // open connection
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setLong(1,categoryID);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    NewsModel news = new NewsModel();
                    news.setId(resultSet.getLong("id"));
                    news.setTitle(resultSet.getString("title"));
                results.add(news);
                }
                return results;
            } catch (SQLException throwables) {
                System.out.println(throwables);
                return null;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }
}
