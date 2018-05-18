package com.fine.distribution.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLogoutSuccessHandler implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":0,\"status\":\"error\",\"msg\":\"");

        sb.append("登出成功");

        sb.append("\"}");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
