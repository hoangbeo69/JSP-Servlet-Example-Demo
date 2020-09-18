package com.jspservletjdbc.controller.admin;

import com.jspservletjdbc.service.INewsService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/home","/login"})
@WebServlet(urlPatterns = {"/admin-news-list"})
public class NewsController extends HttpServlet {
    @Inject
    private INewsService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/list.jsp");
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }
}
