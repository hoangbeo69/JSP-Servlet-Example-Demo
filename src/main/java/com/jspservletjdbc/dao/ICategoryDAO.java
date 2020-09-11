package com.jspservletjdbc.dao;

import com.jspservletjdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO  extends GenericDAO<CategoryModel>{
    List<CategoryModel> findAll();
}
