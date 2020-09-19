package com.jspservletjdbc.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;


/**
 * @author Smurf3r
 * Lớp này được viết nhằm,khi có các request gủi đến,đem theo đó là các
 * tham số ở trong URL,thì lớp này thực hiện việc lấy các tham số đó
 * và tự nó mapping với các loại request các nhau hay các model khác nhau
 * để sử dụng vào nhiều mục đích
 */
public class FormUtil {

    /**
     *Chuyển được dữ liệu từ request thì chuyển sang mapping được với model
     * @param tClass
     * là lớp truyền vào để biết ép sang kiểu model nào
     * @param request
     * là request được yêu cầu từ client,dạng dữ liệu của nó là kiểu key:value
     * @param <T>
     * là 1 trong các model
     * @return
     * trả về model đã được set các dữ liệu lấy từ request
     */
    public static <T> T toModel(Class<T> tClass, HttpServletRequest request){
            T object = null;
        try {
            object = tClass.newInstance(); //khởi tạo đối tượng
            BeanUtils.populate(object,request.getParameterMap());
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
        return object;
    }

}
