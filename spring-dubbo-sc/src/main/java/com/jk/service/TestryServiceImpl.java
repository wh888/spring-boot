package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.TestryMapper;
import com.jk.model.Testry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(version = "1.0")
public class TestryServiceImpl implements TestryService{
  @Autowired
   private TestryMapper testryMapper;
    @Override
    public List<Testry> querytest() {

        return testryMapper.querytest();
    }

    @Override
    public void del(String testid) {
        testryMapper.del(testid);
    }

    @Override
    public void addd(Testry testry) {
        testryMapper.addd(testry);
    }

    @Override
    public Testry xian(Integer testid) {
        return testryMapper.xian(testid);
    }

    @Override
    public void upda(Testry testry) {
        testryMapper.upda(testry);
    }
}
