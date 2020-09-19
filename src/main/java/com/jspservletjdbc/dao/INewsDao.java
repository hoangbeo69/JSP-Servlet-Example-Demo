package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.NewsModel;

import java.util.List;

public interface INewsDao extends GenericDAO {
    List<NewsModel> findByCategoryId(Long categoryID);
    Long save(NewsModel newsModel);
    NewsModel findOne(Long id);
    void update(NewsModel updateModel);
    void delete(long id);
    List<NewsModel> findAll(int offset,int limit);
    int count();
}
