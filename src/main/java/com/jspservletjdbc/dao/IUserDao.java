package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.UserModel;

public interface IUserDao extends GenericDAO<UserModel> {
    UserModel findUserNameAndPasswordStatus(String userName,String passWord,int status);
}
