package com.jspservletjdbc.mapper;

import com.jspservletjdbc.model.CategoryModel;

import java.sql.ResultSet;

public class CategoryMapper implements RowMapper<CategoryModel> {

    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel category = new CategoryModel();
        try{
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setCode(rs.getString("code"));
            return  category;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
