package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();

}
