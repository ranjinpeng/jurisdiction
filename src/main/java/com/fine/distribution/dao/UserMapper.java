package com.fine.distribution.dao;

import com.fine.distribution.MyMapper;
import com.fine.distribution.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends MyMapper<User> {
    @Select("SELECT * from user u where u.phone=#{phone}")
    User userbyphone(@Param("phone") String  phone);
}