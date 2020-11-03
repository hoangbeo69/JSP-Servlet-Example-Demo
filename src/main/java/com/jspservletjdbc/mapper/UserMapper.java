package com.jspservletjdbc.mapper;

import com.jspservletjdbc.model.RoleModel;
import com.jspservletjdbc.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel user = new UserModel();
        RoleModel role = new RoleModel();
        try {
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setFullName(rs.getString("fullname"));
            user.setPassWord(rs.getString("password"));
            user.setRoleId(rs.getLong("roleid"));
            user.setStatus(rs.getLong("status"));

            role.setName(rs.getString("name"));
            role.setCode(rs.getString("code"));
            user.setRoleModel(role);
            return  user;
        } catch (SQLException throwables) {
            return  null;
        }
    }
}
