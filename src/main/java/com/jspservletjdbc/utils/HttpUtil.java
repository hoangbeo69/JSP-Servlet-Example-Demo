package com.jspservletjdbc.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }
    //trả về kiểu model tương ứng với string đưa vào
    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value,tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
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
