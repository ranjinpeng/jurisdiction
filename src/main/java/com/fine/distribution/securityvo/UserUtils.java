package com.fine.distribution.securityvo;


import com.fine.distribution.common.LoginVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtils {
    public static LoginVo getCurrentHr() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        return (LoginVo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
