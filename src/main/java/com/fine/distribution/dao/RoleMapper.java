package com.fine.distribution.dao;

import com.fine.distribution.MyMapper;
import com.fine.distribution.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {

    @Select("SELECT r.* from  role r,userrights u,userrights_role ur where ur.rid=r.id and ur.userid=u.id  and u.id=#{id}")
    List<Role> selectByuserId(@Param("id") Integer id);
}