package com.jspservletjdbc.controller.admin;

import com.jspservletjdbc.constant.SystemConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.File;

@WebServlet(urlPatterns = {"/admin-news-list/uploadfile"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadFileController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "upload";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/uploadfile.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        filePart.write(SystemConstant.PATHFILESAVE+"IMG"+fileName);
    }
}
