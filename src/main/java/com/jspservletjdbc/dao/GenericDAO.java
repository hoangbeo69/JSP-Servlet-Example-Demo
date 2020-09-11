package com.jspservletjdbc.dao;

import com.jspservletjdbc.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T>{
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
