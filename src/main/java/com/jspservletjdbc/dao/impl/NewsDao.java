package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.mapper.NewsMapper;
import com.jspservletjdbc.mapper.RowMapper;
import com.jspservletjdbc.model.CategoryModel;
import com.jspservletjdbc.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends AbstractDAO implements INewsDao {
    @Override
    public List<NewsModel> findByCategoryId(Long categoryID) {
        String sql = "Select * From news Where categoryid = ?";
        return  query(sql,new NewsMapper(),categoryID);
    }

}
