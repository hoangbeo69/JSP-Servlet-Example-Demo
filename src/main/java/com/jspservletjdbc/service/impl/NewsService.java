package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.ICategoryDAO;
import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.CategoryModel;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.paging.Pageble;
import com.jspservletjdbc.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {
    @Inject
    private ICategoryDAO categoryDAO;
    @Inject
    private INewsDao newsDao;
    @Override
    public List<NewsModel> findByCategoryID(long categoryID) {
        return newsDao.findByCategoryId(categoryID);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
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
    public void delete(Long[] ids) {
        for (long id : ids) {
            newsDao.delete(id);
        }
    }

    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        return newsDao.findAll(pageble);
    }


    @Override
    public int getTotalItem() {
        return  newsDao.count();
    }

    @Override
    public NewsModel findOne(long id) {
        NewsModel newsModel = newsDao.findOne(id);
        CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
        newsModel.setCategoryCode(categoryModel.getCode());
        return newsModel;
    }

}
