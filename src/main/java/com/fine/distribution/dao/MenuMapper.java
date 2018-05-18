package com.fine.distribution.dao;

import com.fine.distribution.MyMapper;
import com.fine.distribution.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {
    @Select("SELECT * FROM menu WHERE parentId=#{id}")
    List<Menu> selectbyparentid(@Param("id") Integer id);

    List<Menu> selectallmenubyuserid();
}