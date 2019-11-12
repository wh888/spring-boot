package com.jk.service;

import com.jk.model.Jue;
import com.jk.model.Tree;

import java.util.List;

public interface JueService {
    List<Jue> queryjue(Jue jue);

    void zeng(Jue jue);

    void deljs(Integer rid);

    Jue xiu(Integer rid);

    void xiugai(Jue jue);

    List<Tree> queryMenu(int pid, int rid);

    void zui(int rid, String menuids);
}
