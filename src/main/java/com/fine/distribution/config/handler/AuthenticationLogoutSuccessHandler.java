package com.fine.distribution.config.handler;

import com.alibaba.fastjson.JSON;
import com.fine.distribution.common.ResultGenerator;
import com.fine.distribution.config.handler.utils.RequestUtils;
import com.fine.distribution.config.handler.utils.ResponseUtils;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangrd on 2017/7/4.
 */
public class AuthenticationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private static final String LOGIN_ERROR_RESULT = JSON.toJSONString(ResultGenerator.ok("退出成功"));

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        if (RequestUtils.isAjax(request)) {
            ResponseUtils.print(response,LOGIN_ERROR_RESULT);
        } else {
            super.onLogoutSuccess(request, response, auth);
        }
    }
}
