package com.jk.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jk.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	@Select("select * from user")
	List<User> queryyh(@Param("user") User user);
    @Delete("delete from user where uid=#{id}")
    void shan(@Param("id") Integer uid);

    void zeng(User user);
    @Select("select * from user where uid=#{id}")
    User xiu(@Param("id") Integer uid);

    void xiugai(User user);

    List<Integer> querybyid(@Param("uid")Integer uid);

    void save(@Param("uid")int uid,@Param("rids")String[] ridarr);
}