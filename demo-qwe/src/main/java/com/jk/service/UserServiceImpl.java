package com.jk.service;

import com.jk.mapper.JueMapper;
import com.jk.mapper.UserMapper;
import com.jk.model.Jue;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JueMapper jueMapper;

    @Override
    public List<User> queryyh(User user) {

        return userMapper.queryyh(user);
    }

    @Override
    public void shan(Integer uid) {
        userMapper.shan(uid);
    }

    @Override
    public void zeng(User user) {
        userMapper.zeng(user);
    }

    @Override
    public User xiu(Integer uid) {

        return userMapper.xiu(uid);
    }

    @Override
    public void xiugai(User user) {
        userMapper.xiugai(user);
    }

    @Override
    public List<Jue> she(Integer uid) {
        List<Jue> list1=jueMapper.queryall();
        List<Integer> list2=userMapper.querybyid(uid);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).getRid() == list2.get(j)) {
                    list1.get(i).setUzt("checked");
                }

            }
        }

        return list1;
    }

    @Override
    public void save(int uid, String rids) {
        userMapper.shan(uid);
        String[] ridarr=rids.split(",");
        userMapper.save(uid,ridarr);
    }
}
