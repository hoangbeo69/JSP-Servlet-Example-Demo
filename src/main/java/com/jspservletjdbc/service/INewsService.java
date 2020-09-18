package com.jspservletjdbc.service;

import com.jspservletjdbc.model.NewsModel;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryID(long categoryID);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel updateNews);
    void delete(long[] ids);
    List<NewsModel> findAll();
}
