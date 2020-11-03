package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.IUserDao;
import com.jspservletjdbc.dao.impl.UserDao;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private UserDao userDao;

    @Override
    public UserModel findUserByNameAndPasswordStatus(String userName, String password, int status) {
        return userDao.findUserNameAndPasswordStatus(userName,password,status);
    }
}
