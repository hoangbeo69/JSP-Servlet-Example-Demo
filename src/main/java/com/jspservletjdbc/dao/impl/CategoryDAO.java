package com.jspservletjdbc.dao.impl;

import com.jspservletjdbc.dao.GenericDAO;
import com.jspservletjdbc.dao.ICategoryDAO;
import com.jspservletjdbc.mapper.CategoryMapper;
import com.jspservletjdbc.mapper.RowMapper;
import com.jspservletjdbc.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

    @Override
    public List<CategoryModel> findAll() {
        String sql = "Select * From category";
        return query(sql,new CategoryMapper());
    }

    @Override
    public CategoryModel findOne(Long categoryId) {
        String sql = "Select * From category Where id = ?";
        List<CategoryModel> list = query(sql,new CategoryMapper(),categoryId);
        return  list.isEmpty() ? null : list.get(0);
    }

}
