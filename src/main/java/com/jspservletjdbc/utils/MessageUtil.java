package com.jspservletjdbc.utils;

import com.jspservletjdbc.constant.SystemConstant;
import com.jspservletjdbc.model.MessageModel;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class MessageUtil {
    public static void showMessage(HttpServletRequest request) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
        MessageModel messageModel = new MessageModel();
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");
        if(request.getParameter("message") != null){
            messageModel.setMessage(resourceBundle.getString(message));
            messageModel.setAlert(resourceBundle.getString(alert));
            request.setAttribute(SystemConstant.MESSAGE,messageModel);
        }
    }
}
