package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.GenericDAO;
import com.jspservletjdbc.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

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
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);

            //set tham số cho cho câu query nếu có
            setParameter(statement, parameters);

            rs = statement.executeQuery();
            while (rs.next()) {
                results.add(rowMapper.mapRow(rs));
            }
            return results;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int count = 0; count < parameters.length; count++) {
                Object parameter = parameters[count];
                int index = count + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (long) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
