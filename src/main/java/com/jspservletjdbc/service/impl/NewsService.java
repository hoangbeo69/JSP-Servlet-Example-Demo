package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
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
        long newID = newsDao.save(newsModel);
        return newsDao.findOne(newID);
    }

    @Override
    public NewsModel update(NewsModel updateNews) {
        NewsModel oldNews = newsDao.findOne(updateNews.getId());
        updateNews.setCreateDate(oldNews.getCreateDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        newsDao.update(updateNews);
        return newsDao.findOne(updateNews.getId());
    }

    @Override
    public void delete(long[] ids) {
        for(int count = 0 ; count < ids.length ; count++){
            newsDao.delete(ids[count]);
        }
    }

}
