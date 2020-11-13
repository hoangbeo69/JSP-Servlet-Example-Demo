package com.jspservletjdbc.controller.admin;

import com.jspservletjdbc.constant.SystemConstant;
import com.jspservletjdbc.model.AbstractModel;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.paging.PageRequest;
import com.jspservletjdbc.paging.Pageble;
import com.jspservletjdbc.service.ICategoryService;
import com.jspservletjdbc.service.INewsService;
import com.jspservletjdbc.service.impl.NewsService;
import com.jspservletjdbc.sort.Sorter;
import com.jspservletjdbc.utils.FormUtil;

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
    @Inject
    private ICategoryService categoryService;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * Thực hiện kiểm tra đầu giá trị của request
     * nếu type là list thì đơn giản trả về list new
     * nếu type là single thì có thể hành dộng xóa hoặc sửa
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        NewsModel model = FormUtil.toModel(NewsModel.class,request);
        String view ="";
        if(model.getType().equals(SystemConstant.LIST)){
            Pageble pageble = new PageRequest(model.getPage(),model.getMaxPageItem(),
                    new Sorter(model.getSortName(),model.getSortBy()));
            model.setListResult(newsService.findAll(pageble));
            model.setTotalIem(newsService.getTotalItem());
            model.setTotalPage((int) Math.ceil(model.getTotalIem())/model.getMaxPageItem());
            view = "/views/admin/news/list.jsp";
        }else if (model.getType().equals(SystemConstant.SINGLE)){
            if(model.getId() != null){
                model = newsService.findOne(model.getId());
            }
            request.setAttribute("categories", categoryService.findAll());
            view = "/views/admin/news/edit.jsp";
        }
        request.setAttribute(SystemConstant.MODEL,model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request,response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    }
}
