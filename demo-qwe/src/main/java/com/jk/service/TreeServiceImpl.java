package com.jk.service;

import com.jk.mapper.TreeMapper;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService{
    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> querytree(int pid) {
        List<Tree> list= treeMapper.querytree(pid);
        if (list !=null && list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                List<Tree> menus=querytree(list.get(i).getId());
                list.get(i).setChildren(menus);
            }
        }
        return list;
    }

    @Override
    public List<Tree> queryshui(Tree tree) {

        return treeMapper.queryshui(tree);
    }

    @Override
    public void chu(String id) {
        treeMapper.chu(id);
    }
}
