package com.jk.mapper;

import com.jk.model.Testry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestryMapper {

    List<Testry> querytest();

    void del(@Param("id") String testid);

    void addd(Testry testry);

    Testry xian(@Param("id") Integer testid);

    void upda(Testry testry);
}