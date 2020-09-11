package com.jspservletjdbc.service;

import com.jspservletjdbc.model.NewsModel;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryID(long categoryID);
}
