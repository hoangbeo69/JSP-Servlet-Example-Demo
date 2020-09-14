package com.jspservletjdbc.mapper;

import com.jspservletjdbc.model.NewsModel;

import java.sql.ResultSet;

public class NewsMapper implements RowMapper<NewsModel>{

    @Override
    public NewsModel mapRow(ResultSet rs) {
        NewsModel news = new NewsModel();
        try{
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setCategoryId(rs.getLong("categoryId"));
            news.setShortDescription(rs.getString("shortdescription"));
            news.setThumbnail(rs.getString("thumbnail"));
            return  news;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
