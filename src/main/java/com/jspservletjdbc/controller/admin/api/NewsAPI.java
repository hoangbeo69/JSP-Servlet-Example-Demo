package com.jspservletjdbc.controller.admin.api;

import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.service.impl.NewsService;
import com.jspservletjdbc.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {

    @Inject
    public NewsService newsService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //đinh dạng định dạng dữ liệu truyền vào có thể đọc tiếng việt
        resp.setContentType("application/json");  // set kiểu dữ liệu đầu ra là kiểu json
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        newsModel = newsService.save(newsModel);
        System.out.println(newsModel);
    }
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPut(req, resp);
//
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
//
//    }
}
