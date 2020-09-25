package com.jspservletjdbc.paging;

import com.jspservletjdbc.sort.Sorter;

public interface Pageble {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSoter();
}
