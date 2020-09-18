package com.jspservletjdbc.controller.admin;

import com.jspservletjdbc.constant.SystemConstant;
import com.jspservletjdbc.model.AbstractModel;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.service.INewsService;
import com.jspservletjdbc.service.impl.NewsService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@WebServlet(urlPatterns = {"/home","/login"})
@WebServlet(urlPatterns = {"/admin-news-list"})
public class NewsController extends HttpServlet {
    @Inject
    private INewsService newsService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        NewsModel model = new NewsModel();
        model.setListResult(newsService.findAll());
        request.setAttribute(SystemConstant.MODEL,model);
        System.out.println(model.getListResult());
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/list.jsp");
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }
}
