package com.jk.controller;

import com.jk.model.Testry;
import com.jk.service.TestryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestryController {
    @Autowired
    private TestryService testryService;

    @RequestMapping("query")
    public String query(){
        return "show";
    }
    @RequestMapping("querytest")
    @ResponseBody
    public List<Testry> querytest(){
        return testryService.querytest();
    }
    @RequestMapping("del")
    @ResponseBody
    public void del(String testid){
        testryService.del(testid);
    }
    @RequestMapping("add")
    public String add(){
        return "add";
    }
    @RequestMapping("addd")
    @ResponseBody
    public int addd(Testry testry){
        testryService.addd(testry);
        return 1;
    }
    @RequestMapping("xiu")
    public String xian(Testry testry, Model model){
        testry=testryService.xian(testry.getTestid());
        model.addAttribute("t",testry);
        return "hui";
    }
    @RequestMapping("xiugai")
    @ResponseBody
    public int upda(Testry testry){
        testryService.upda(testry);
        return 1;
    }

}
