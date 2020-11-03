package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.IUserDao;
import com.jspservletjdbc.mapper.UserMapper;
import com.jspservletjdbc.model.UserModel;

import javax.swing.tree.RowMapper;
import java.util.List;

public class UserDao extends AbstractDAO<UserModel> implements IUserDao{

    @Override
    public UserModel findUserNameAndPasswordStatus(String userName, String passWord, int status) {
        StringBuilder sql = new StringBuilder("Select * From user as u ");
        sql.append("Inner Join role as r On r.id = u.id ");
        sql.append("Where username = ? And password =? status = ?");
        List<UserModel> users = query(sql.toString(),new UserMapper(),userName,passWord,status);
        return users.isEmpty() ? null : users.get(0);
    }
}
