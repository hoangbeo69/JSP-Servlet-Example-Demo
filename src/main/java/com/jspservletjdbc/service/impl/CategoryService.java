package com.jspservletjdbc.service.impl;

import com.jspservletjdbc.dao.ICategoryDAO;
import com.jspservletjdbc.model.CategoryModel;
import com.jspservletjdbc.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
//      Gọi kiểu cơ bản
//    private ICategoryDAO categoryDAO;
//
//    public CategoryService(){
//        categoryDAO = new CategoryDAO();
//    }
    //sử dụng Java Servlet Weld
    @Inject
    private ICategoryDAO categoryDAO;

    public List<CategoryModel> findAll(){
        return  categoryDAO.findAll();
    }
}