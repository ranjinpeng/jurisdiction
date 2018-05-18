package com.fine.distribution.config;

import com.fine.distribution.common.LoginVo;
import com.fine.distribution.dao.RoleMapper;
import com.fine.distribution.dao.UserMapper;
import com.fine.distribution.entity.Role;
import com.fine.distribution.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserDetail  implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;


    /*
        实现UserDetailsService 接口 重新登录验证！  需要返回一个UserDetails对象 也是登录用户对象
        在 org.springframework.security.core.userdetails.User 中 有默认的 但是建议重写一个
        LoginVo就是重写的UserDetails对象  里面可以封装自己要的属性
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u=userMapper.userbyphone(s);
        if (u == null) {
            throw new UsernameNotFoundException("not found");
        }

        List<Role>  roles  =roleMapper.selectByuserId(u.getRightsid());

        LoginVo loginVo=new LoginVo();
        loginVo.setId(u.getUserid());
        loginVo.setUsername(u.getName());
        loginVo.setPassword(u.getPassword());
        loginVo.setRoles(roles);
        loginVo.setUserrightsid(u.getRightsid());
        return loginVo;
    }

}
