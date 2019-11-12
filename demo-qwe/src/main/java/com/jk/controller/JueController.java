package com.jk.controller;

import com.jk.model.Jue;
import com.jk.model.Tree;
import com.jk.service.JueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JueController {
    @Autowired
    private JueService jueService;

    @RequestMapping("queryjue")
    public String queryjue(){
        return "showjue";
    }
    @RequestMapping("queryju")
    @ResponseBody
    public List<Jue> queryjue(Jue jue){
        return jueService.queryjue(jue);
    }
    @RequestMapping("addo")
    public String addo(){
        return "addjs";
    }
    @RequestMapping("addi")
    @ResponseBody
    public int zeng(Jue jue){
        jueService.zeng(jue);
        return 1;
    }
    @RequestMapping("deljs")
    @ResponseBody
    public void deljs(Integer rid){
        jueService.deljs(rid);
    }
    @RequestMapping("xiui")
    public String xiu(Jue jue, Model model){
        jue=jueService.xiu(jue.getRid());
        model.addAttribute("j",jue);
        return "xiugaijs";
    }
    @RequestMapping("xiugaiii")
    @ResponseBody
    public int xiugai(Jue jue){
        jueService.xiugai(jue);
        return 1;
    }
    @RequestMapping("fuiquan")
    public String fuquan(int rid,Model model){
        model.addAttribute("rid",rid);
        return "fuquan";
    }
    @RequestMapping("queryMenu")
    @ResponseBody
    public List<Tree> queryMenu(int rid){
        return jueService.queryMenu(-1,rid);
    }
    @RequestMapping("zui")
    @ResponseBody
    public String zui(int rid,String menuids){
        jueService.zui(rid,menuids);
        return "suc";
    }
}
