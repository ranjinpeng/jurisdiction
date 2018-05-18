package com.fine.distribution.securityvo;


import com.fine.distribution.common.LoginVo;
import com.fine.distribution.utlis.HospitalException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtils {
    public static LoginVo getCurrent() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(a.getPrincipal());//因为组件控制器是所以权限都可以访问的 所以没有登录验证我们自定义配置的spring security没权限拦截器无效 自己判断抛出异常
        if (a.getPrincipal().equals("anonymousUser")){
            throw  new HospitalException(-1);
        }

        return (LoginVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
