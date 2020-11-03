package com.jspservletjdbc.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    /**
     * @param tClass
     * @param <T>
     * @return
     * trả về object tương ứng với đối tượng muốn ép
     * @apiNote hàm này nhằm ép kiểu từ một string json sang 1 object cần ép
     */
    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value,tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param reader
     * luồng dữ liệu vào có thể là kiểu text gì đó
     * @return
     * trả về một string json với dữ liệu đầu vào là luồng đọc là api được gửi từ client đến
     */
    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while (true) {
                if (!((line = reader.readLine()) != null)) break;
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return new HttpUtil(sb.toString());
    }
}
