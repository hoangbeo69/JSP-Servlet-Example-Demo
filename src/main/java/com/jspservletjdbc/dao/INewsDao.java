package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.NewsModel;

import java.util.List;

public interface INewsDao {
    List<NewsModel> findByCategoryId(Long categoryID);
}
