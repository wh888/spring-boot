package com.jk.service;

import com.jk.model.Tree;

import java.util.List;

public interface TreeService {
    List<Tree> querytree(int pid);

    List<Tree> queryshui(Tree tree);

    void chu(String id);
}
