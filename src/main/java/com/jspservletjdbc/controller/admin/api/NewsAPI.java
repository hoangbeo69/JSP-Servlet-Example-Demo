package com.jspservletjdbc.controller.admin.api;

import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.service.impl.NewsService;
import com.jspservletjdbc.utils.HttpUtil;
import com.jspservletjdbc.utils.SessionUtil;
import org.codehaus.jackson.map.ObjectMapper;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//        upload file to server using jsp,servlet
//        https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet/2424824#2424824
@WebServlet(urlPatterns = {"/api-admin-news"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
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
        newsModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL")).getUserName());
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
        deleteNews.setModifiedBy(((UserModel)(SessionUtil.getInstance()).getValue(req,"USERMODEL")).getUserName());
        newsService.delete(deleteNews.getIds());
        mapper.writeValue(resp.getOutputStream(),"{}");
    }

}
