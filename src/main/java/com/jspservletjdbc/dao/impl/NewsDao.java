package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.mapper.NewsMapper;
import com.jspservletjdbc.model.NewsModel;

import java.sql.*;
import java.util.List;

public class NewsDao extends AbstractDAO implements INewsDao {
    @Override
    public List<NewsModel> findByCategoryId(Long categoryID) {
        String sql = "Select * From news Where categoryid = ?";
        return query(sql, new NewsMapper(), categoryID);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "Insert Into news(title,content,categoryid) Values(?,?,?)";
        return insert(sql,newsModel.getTitle(),newsModel.getContent(),newsModel.getCategoryId());
    }

}
