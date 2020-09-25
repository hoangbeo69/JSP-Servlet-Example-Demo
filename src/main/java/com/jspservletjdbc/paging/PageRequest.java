package com.jspservletjdbc.paging;

import com.jspservletjdbc.sort.Sorter;

public class PageRequest implements Pageble {
    private Integer page;
    private Integer maxPageitem;
    private Sorter sorter;

    public PageRequest() {

    }

    public PageRequest(Integer page, Integer limit, Sorter sorter) {
        this.maxPageitem = limit;
        this.page = page;
        this.sorter = sorter;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffset() {
        if (this.page != null && this.maxPageitem != null) {
            return (this.page - 1) * this.maxPageitem;
        }
        return null;
    }

    @Override
    public Integer getLimit() {
        return this.maxPageitem;
    }

    @Override
    public Sorter getSoter() {
        if (this.sorter != null) {
            return this.sorter;
        }
        return null;
    }
}
