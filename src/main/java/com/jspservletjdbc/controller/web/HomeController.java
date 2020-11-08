package com.jspservletjdbc.controller.web;

import com.jspservletjdbc.dao.INewsDao;
import com.jspservletjdbc.model.NewsModel;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.service.ICategoryService;
import com.jspservletjdbc.service.INewsService;
import com.jspservletjdbc.service.IUserService;
import com.jspservletjdbc.utils.FormUtil;
import com.jspservletjdbc.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

//@WebServlet(urlPatterns = {"/home","/login"})
@WebServlet(urlPatterns = {"/home","/login","/logout"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IUserService userService;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        RequestDispatcher rd = null;
        String action = request.getParameter("action") == null ? "home":request.getParameter("action") ;
//        if(action != null && action.equals("login")){
//            rd = request.getRequestDispatcher(request.getContextPath()+"/views/login.jsp");
//            rd.forward(request,response);
//            if()
//        }else if(action != null && action.equals("logout")){
//            SessionUtil.getInstance().removeValue(request,"USERMODEL");
//            response.sendRedirect(request.getContextPath()+"/login?action=login");
//        }

            switch (action) {
                case "login":
                    rd = request.getRequestDispatcher(request.getContextPath() + "/views/login.jsp");
                    String message = request.getParameter("message");
                    String alert = request.getParameter("alert");
                    if(message != null  && alert != null ){
                        request.setAttribute("message",resourceBundle.getString(message));
                        request.setAttribute("alert",alert);
                    }
                    rd.forward(request, response);
                    break;

                case "logout":
                    SessionUtil.getInstance().removeValue(request, "USERMODEL");
                    response.sendRedirect(request.getContextPath() + "/login?action=login");
                    break;

                default:
                    request.setAttribute("categories", categoryService.findAll());
                    rd = request.getRequestDispatcher("/views/web/home.jsp");
                    rd.forward(request, response);
                    break;
            }
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String action =request.getParameter("action");
        if(action!= null && action.equals("login")){
            UserModel user = FormUtil.toModel(UserModel.class,request);
            user = userService.findUserByNameAndPasswordStatus(user.getUserName(),user.getPassWord(),1);
            SessionUtil.getInstance().putValue(request,"USERMODEL",user);

            if(user == null){
                response.sendRedirect(request.getContextPath()+"/login?action=login&message=userpassword_invalid&alert=danger");
            }else {
                if(user.getRoleModel().getName().equals("USER")){
                    response.sendRedirect(request.getContextPath()+"/home");
                }else if(user.getRoleModel().getName().equals("ADMIN")){
                    response.sendRedirect(request.getContextPath()+"/admin-home");
                }
            }

        }else {
            response.sendRedirect(request.getContextPath()+"/home");
        }
    }
}
