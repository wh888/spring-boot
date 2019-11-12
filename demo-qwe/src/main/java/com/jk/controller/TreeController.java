package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("query")
    public String query(){
        return "show";
    }
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> querytree(){
        return treeService.querytree(-1);
    }
    @RequestMapping("queryshu")
    public String queryshu(){
        return "shu";
    }
    @RequestMapping("queryshui")
    @ResponseBody
    public List<Tree> queryshui(Tree tree){
        return treeService.queryshui(tree);
    }
    @RequestMapping("chu")
    @ResponseBody
    public void chu(String id){
        treeService.chu(id);
    }

}
