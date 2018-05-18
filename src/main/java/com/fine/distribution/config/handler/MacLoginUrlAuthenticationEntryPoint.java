package com.fine.distribution.config.handler;

import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MacLoginUrlAuthenticationEntryPoint  implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.core.AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":-1,\"status\":\"error\",\"msg\":\"");

        sb.append("未登陆!");

        sb.append("\"}");
        out.write(sb.toString());
        out.flush();
        out.close();

    }


}


