package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.ICategoryDAO;
import com.jspservletjdbc.dao.impl.CategoryDAO;
import com.jspservletjdbc.model.CategoryModel;
import com.jspservletjdbc.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
//      Gọi kiểu cơ bản
    private ICategoryDAO categoryDAO;

    public CategoryService(){
        categoryDAO = new CategoryDAO();
    }

    public List<CategoryModel> findAll(){
        return  categoryDAO.findAll();
    }
}