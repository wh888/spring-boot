package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service(version = "1.0")
public class CarServiceImpl implements CarService{
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Map<String,Object>> querycar() {

        return carMapper.querycar();
    }

    @Override
    public List<Map<String, Object>> querycarall() {
        return carMapper.querycarall();
    }

    @Override
    public List<Map<String, Object>> querymian() {
        return carMapper.querymian();
    }

    @Override
    public List<Map<String, Object>> queryzhu() {
        return carMapper.queryzhu();
    }
}
