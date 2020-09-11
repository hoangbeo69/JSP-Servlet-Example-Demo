package com.jspservletjdbc.dao;

import java.util.List;

public interface GenericDAO<T>{
    <T> List<T> query(String sql,,Object... parameters);
}
