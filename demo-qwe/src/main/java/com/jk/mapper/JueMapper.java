package com.jk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jk.model.Jue;

public interface JueMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Jue record);

    int insertSelective(Jue record);

    Jue selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Jue record);

    int updateByPrimaryKey(Jue record);

	@Select("select * from jue")
	List<Jue> queryjue(@Param("jue") Jue jue);

	List<Jue> queryall();

	void zeng(Jue jue);
	@Delete("delete from jue where rid = #{id}")
	void deljs(@Param("id") Integer rid);
	@Select("select * from jue where rid=#{id}")
	Jue xiu(@Param("id") Integer rid);

	void xiugai(Jue jue);
}