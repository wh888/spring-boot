package com.jk.mapper;

import com.jk.model.Car;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Map<String,Object>> querycar();

    List<Map<String, Object>> querycarall();

    List<Map<String, Object>> querymian();

    List<Map<String, Object>> queryzhu();
}