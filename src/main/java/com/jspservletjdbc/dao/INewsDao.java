package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.paging.Pageble;

import java.awt.print.Pageable;
import java.util.List;

public interface INewsDao extends GenericDAO {
    List<NewsModel> findByCategoryId(Long categoryID);
    Long save(NewsModel newsModel);
    NewsModel findOne(Long id);
    void update(NewsModel updateModel);
    void delete(long id);
    List<NewsModel> findAll(Pageble pageble);
    int count();
}
