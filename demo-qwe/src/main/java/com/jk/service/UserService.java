package com.jk.service;

import com.jk.model.Jue;
import com.jk.model.User;

import java.util.List;

public interface UserService {
    List<User> queryyh(User user);

    void shan(Integer uid);

    void zeng(User user);

    User xiu(Integer uid);

    void xiugai(User user);

    List<Jue> she(Integer uid);

    void save(int uid, String rids);
}
