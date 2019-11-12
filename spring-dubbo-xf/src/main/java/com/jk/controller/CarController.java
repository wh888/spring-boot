package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {
    @Reference(version = "1.0")
    public CarService carService;

    @RequestMapping("bing")
    public String bing(){
        return "bing";
    }
    @RequestMapping("queryCar")
    @ResponseBody
    public List<Map<String,Object>> querycar(){
        List<Map<String,Object>> map1=carService.querycar();
        List<Map<String,Object>> map2=new ArrayList<Map<String,Object>>();
       for (Map<String,Object> map:map1){
           Map<String,Object> map3=new HashMap<>();
           map3.put("y",map.get("y"));
          /* if(map.get("类型").toString().equals("1")){
               map3.put("name","跑车");
               map3.put("sliced",true);
               map3.put("selected",true);
           }else if(map.get("类型").toString().equals("2")){
               map3.put("name","suv");
           }else{
               map3.put("name","轿车");
           }*/
          map3.put("name",map.get("name"));
            map2.add(map3);
       }
       return map2;
    }
    @RequestMapping("queryCarAll")
    @ResponseBody
    public List<Map<String,Object>> querycarall(){
        List<Map<String,Object>> map=carService.querycarall();
        List<Map<String,Object>> map2=new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map1:map){
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("data",map1.get("count"));
           // map3.put("ha",map1.get("name"));
            map2.add(map3);
        }
        return map;
    }
    @RequestMapping("xian")
    public String xian(){
        return "xian";
    }
    @RequestMapping("querymian")
    @ResponseBody
    public List<Map<String,Object>> querymian(){
        List<Map<String,Object>> map=carService.querymian();
        List<Map<String,Object>> map2=new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map1:map){
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("carname"));
            map3.put("data",map1.get("counts"));
            map2.add(map3);
        }
        return map;

    }
    @RequestMapping("queryzhu")
    @ResponseBody
    public List<Map<String,Object>> queryzhu(){
        List<Map<String,Object>> map=carService.queryzhu();
        List<Map<String,Object>> map2=new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map1:map){
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("moneyii"));
            map3.put("data",map1.get("timeii"));
            map2.add(map3);
        }
        return map;

    }
}
