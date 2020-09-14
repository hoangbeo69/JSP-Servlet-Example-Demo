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

    @Override
    public void update(String sql, Object... parameters) {
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement,parameters);
            connection.commit();
        }catch (SQLException e){
            if (connection != null) {
                try {
                    connection.rollback(); //nếu 1 trong các commit phía trên thì nó sẽ quay trở về như ban đầu khi chưa insert
                } catch (SQLException throwables) {
                    System.out.println(e);
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        ResultSet resultSet = null;
        Long id = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //thêm phần Statemen.Return_Generated..=>để có thể sủ dụng được lấy cái keyid vừa truy vấn
            setParameter(statement,parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit(); //commit các câu truy vấn => các dữ liệu bắt đầu thay đổi
            return id;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); //nếu 1 trong các commit phía trên thì nó sẽ quay trở về như ban đầu khi chưa insert
                } catch (SQLException throwables) {
                    System.out.println(e);
                }
            }
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
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Timestamp){
                    statement.setTimestamp(index,(Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}