package com.jspservletjdbc.model;

import java.sql.Timestamp;

public class AbstractModel {
    private long id;
    private Timestamp createDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private long[] ids;

    public void setIds(long[] ids){
        this.ids = ids;
    }
    public long[] getIds(){
        return ids;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
