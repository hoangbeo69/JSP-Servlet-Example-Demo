package com.jspservletjdbc.service;

import com.jspservletjdbc.model.UserModel;

public interface IUserService {
    UserModel findUserByNameAndPasswordStatus(String userName,String Password,int status);
}
