package com.jk.controller;

import com.jk.model.Jue;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryyong")
    public String queryyong(){
        return "yh";
    }

    @RequestMapping("queryyh")
    @ResponseBody
    public List<User> queryyh(User user){
        return userService.queryyh(user);
    }
    @RequestMapping("del")
    @ResponseBody
    public void shan(Integer uid){
        userService.shan(uid);
    }
    @RequestMapping("add")
    public String add(){
        return "add";
    }
    @RequestMapping("addd")
    @ResponseBody
    public int zeng(User user){
        userService.zeng(user);
        return 1;
    }
    @RequestMapping("xiu")
    public String xiu(User user, Model model){
        user=userService.xiu(user.getUid());
        model.addAttribute("u",user);
        return "xiugai";
    }
    @RequestMapping("xiugai")
    @ResponseBody
    public int xiugai(User user){
        userService.xiugai(user);
        return 1;
    }
    @RequestMapping("she")
    public String she(Integer uid,Model model){
        model.addAttribute("uid",uid);
        List<Jue> list=userService.she(uid);
        model.addAttribute("list",list);
        return "she";
    }
    @RequestMapping("save")
    @ResponseBody
    public String save(int uid,String rids){
        userService.save(uid,rids);
        return "suc";
    }
}
