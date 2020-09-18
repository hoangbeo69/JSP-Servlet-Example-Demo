package com.jspservletjdbc.model;

import java.sql.Timestamp;

public class UserModel extends AbstractModel<UserModel>{
    private long id;
    private String userName;
    private String fullName;
    private String passWord;
    private boolean status;
    private long roleId;
    private Timestamp createDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
