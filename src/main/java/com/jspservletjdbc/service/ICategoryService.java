package com.jspservletjdbc.service;

import com.jspservletjdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
