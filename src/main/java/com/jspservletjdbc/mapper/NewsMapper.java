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
            return  news;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
