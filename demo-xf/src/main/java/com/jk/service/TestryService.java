package com.jk.service;

import com.jk.model.Testry;

import java.util.List;

public interface TestryService {
    List<Testry> querytest();

    void del(String testid);

    void addd(Testry testry);

    Testry xian(Integer testid);

    void upda(Testry testry);
}
