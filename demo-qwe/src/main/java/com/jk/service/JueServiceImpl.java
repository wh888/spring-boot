package com.jk.service;

import com.jk.mapper.JueMapper;
import com.jk.mapper.TreeMapper;
import com.jk.model.Jue;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JueServiceImpl implements JueService{
    @Autowired
    private JueMapper jueMapper;
    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Jue> queryjue(Jue jue) {

        return jueMapper.queryjue(jue);
    }

    @Override
    public void zeng(Jue jue) {
        jueMapper.zeng(jue);
    }

    @Override
    public void deljs(Integer rid) {
        jueMapper.deljs(rid);
    }

    @Override
    public Jue xiu(Integer rid) {

        return jueMapper.xiu(rid);
    }

    @Override
    public void xiugai(Jue jue) {
        jueMapper.xiugai(jue);
    }

    @Override
    public List<Tree> queryMenu(int pid, int rid) {
        List<Tree> tree1=treeMapper.querytree(pid);
        List<Integer> rolemenus=treeMapper.querymenubyid(rid);
        if(tree1 !=null && tree1.size() >0){
            for (int i = 0; i < tree1.size(); i++) {
                List<Tree> tree2=queryMenu(tree1.get(i).getId(),rid);
                tree1.get(i).setChildren(tree2);
                for (int j = 0; j < rolemenus.size(); j++) {
                    if(tree2.size()<=0 && tree1.get(i).getId() == rolemenus.get(j)){
                        tree1.get(i).setChecked(true);
                    }
                }
            }
        }
        return tree1;
    }

    @Override
    public void zui(int rid, String menuids) {
        treeMapper.deletebyrid(rid);
        treeMapper.savebyrid(rid,menuids.split(","));
    }
}
