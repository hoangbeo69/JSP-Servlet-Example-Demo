package com.jspservletjdbc.controller.admin.api;

import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.service.impl.NewsService;
import com.jspservletjdbc.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

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
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8"); //đinh dạng định dạng dữ liệu truyền vào có thể đọc tiếng việt
        resp.setContentType("application/json");  // set kiểu dữ liệu đầu ra là kiểu json
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

        newsModel = newsService.save(newsModel);
        mapper.writeValue(resp.getOutputStream(),newsModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

        updateNews = newsService.update(updateNews);
        mapper.writeValue(resp.getOutputStream(),updateNews);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewsModel deleteNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        newsService.delete(deleteNews.getIds());
        mapper.writeValue(resp.getOutputStream(),"{}");

    }
}
