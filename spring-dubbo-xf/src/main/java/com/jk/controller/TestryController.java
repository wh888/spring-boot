package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Testry;
import com.jk.service.TestryService;
import com.jk.util.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestryController {
    @Reference(version = "1.0")
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

    @RequestMapping("export")
    public void export(HttpServletResponse response){
        List<Testry> list= new ArrayList<Testry>();
        try {
            list = testryService.querytest();

            //定义表格的标题
            String title ="测试人员信息";
            //定义列名
            String[] rowName={"编号","测试人员名称","测试人员电话","测试人员性别"};
            //定义工具类要的数据
            List<Object[]>  dataList = new ArrayList<Object[]>();


            //循环数据把数据存放到 List<Object[]>
            for (Testry testry:list) {
                Object[] obj=new Object[rowName.length];
                obj[0]=testry.getTestid();
                obj[1]= testry.getTestname();
                obj[2]=testry.getTestiphone();
                if(testry.getTestsex()==1){
                    obj[3]="男" ;
                }else{
                    obj[3]="女" ;
                }

                dataList.add(obj);
            }
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
