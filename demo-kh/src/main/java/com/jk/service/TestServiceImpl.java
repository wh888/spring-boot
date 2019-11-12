package com.jk.service;

import com.jk.mapper.TestryMapper;
import com.jk.model.Testry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TestryService")
public class TestServiceImpl implements TestryService{
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
