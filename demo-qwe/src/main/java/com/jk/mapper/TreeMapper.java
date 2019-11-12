package com.jk.mapper;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeMapper {

    List<Tree> querytree(@Param("pid") int pid);

    List<Integer> querymenubyid(@Param("rid")int rid);

    void deletebyrid(int rid);

    void savebyrid(@Param("rid")int rid,@Param("mids")String[] split);

    List<Tree> queryshui(@Param("tree")Tree tree);
    @Delete("delete from tree where id = #{id}")
    void chu(@Param("id")String id);
}