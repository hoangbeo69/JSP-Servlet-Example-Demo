package com.jspservletjdbc.controller.web;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.service.ICategoryService;
import com.jspservletjdbc.service.INewsService;
import com.jspservletjdbc.service.IUserService;
import com.jspservletjdbc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/home","/login"})
@WebServlet(urlPatterns = {"/home","/login","/logout"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IUserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

//        UserModel user = new UserModel();
//        user.setFullName("Hell everyone");
//        request.setAttribute("model",user); //đặt tên đối tượng này là model để các file JSP có thể gọi
//        String title = "Ôi bạn ơi";
//        String content = "Đây là test nha bạn ơi";
//        Long categoryId = 1L;
//        NewsModel news = new NewsModel();
//        news.setTitle(title);
//        news.setContent(content);
//        news.setCategoryId(categoryId);
//        newsService.save(news);
        RequestDispatcher rd;
        String action = request.getParameter("action");
        System.out.println("action =" +action);
        if(action != null && action.equals("login")){
            rd = request.getRequestDispatcher("/views/login.jsp");
        }else if(action != null && action.equals("logout")){
            rd = request.getRequestDispatcher("/views/login.jsp");
        }else{
            request.setAttribute("categories",categoryService.findAll());
            rd = request.getRequestDispatcher("/views/web/home.jsp");
        }
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        RequestDispatcher rd =null;
        String action =request.getParameter("action");
        if(action!= null && action.equals("login")){
            UserModel user = FormUtil.toModel(UserModel.class,request);
            System.out.println(user.getPassWord());
            System.out.println(user.getUserName());
            if(user == null){
                rd = request.getRequestDispatcher("/views/login.jsp");
            }else {
                if(user.getRoleModel().getName().equals("USER")){
                    rd = request.getRequestDispatcher("/views/web/home.jsp");
                }else {
                    rd = request.getRequestDispatcher("/views/admin/home.jsp");
                }
            }
        }
        rd.forward(request,response);
    }
}
