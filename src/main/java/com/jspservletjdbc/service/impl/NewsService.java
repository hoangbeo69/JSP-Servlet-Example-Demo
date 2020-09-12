package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.service.INewsService;

import javax.inject.Inject;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    private INewsDao newsDao;
    @Override
    public List<NewsModel> findByCategoryID(long categoryID) {
        return newsDao.findByCategoryId(categoryID);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long newsId = newsDao.save(newsModel);
        System.out.println(newsId);
        return null;
    }

}
