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

    @Override
    public NewsModel findOne(Long id) {
        String sql = "Select * From news Where id = ?";
        List<NewsModel> news =  query(sql,new NewsMapper(),id);
        return news.isEmpty() ? null : (NewsModel) news.get(0);
    }

    @Override
    public void update(NewsModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
        sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
        sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreateDate(),
                updateNew.getCreatedBy(), updateNew.getModifiedDate(),
                updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "Delete From news Where id = ?";
        delete(sql,id);
    }

}
