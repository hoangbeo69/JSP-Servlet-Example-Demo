package com.jspservletjdbc.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    private long id;
    private Timestamp createDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private long[] ids;
    private List<T> listResult = new ArrayList<>();
    private int page = 1; //hiển thị ở page nào
    private int maxPageItem; //tổng số item nhiều nhất trên 1 page
    private int totalPage; //tổng số trang có thể phân ra

    public void setMaxPageItem(int maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public int getMaxPageItem() {
        return maxPageItem;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public List<T> getListResult() {
        return this.listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

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
