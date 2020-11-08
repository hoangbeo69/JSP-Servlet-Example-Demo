package com.jspservletjdbc.filter;

import com.jspservletjdbc.constant.SystemConstant;
import com.jspservletjdbc.model.UserModel;
import com.jspservletjdbc.utils.SessionUtil;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Thực hiện kiểm tra request tới đã thực hiện đăng nhập hay chưa
 * kiểm tra quyền tải khoản có phải admin hay không để được phép vào các url của admin
 */
public class AuthorizationFilter implements Filter {
    private ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if(url.startsWith("/admin")){
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
            if(userModel != null){
                if(userModel.getRoleModel().getName().equals(SystemConstant.ADMIN)){
                    chain.doFilter(servletRequest,servletResponse);
                }else if(userModel.getRoleModel().getName().equals(SystemConstant.USER)){
                    response.sendRedirect(request.getContextPath()+"/login?action=login&message=not_permisstion&alert=danger");
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/login?action=login&message=login_first&alert=danger");
            }
        }else {
            chain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
