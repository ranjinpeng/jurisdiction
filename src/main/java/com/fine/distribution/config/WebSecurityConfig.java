package com.fine.distribution.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fine.distribution.config.handler.*;
import com.fine.distribution.securityvo.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    SecurityUserDetail securityUserDetail;
    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    protected void configure(HttpSecurity http) throws Exception {

//      默认情况下，CSRF保护已启用。你必须配置包含_csrf令牌的所有的网页来工作。
//      你可以随时禁用CSRF保护。如果在代码中配置： 解决post请无法提交
        http.csrf().disable();
        http.cors();//加载自己的解决跨域的拦截器
        http.authorizeRequests()
                .antMatchers("/finance/**").hasRole("FINANCE")//配置那些需要权限 需要那些权限
                .antMatchers("/user/**").hasRole("AGENT")
                .antMatchers(HttpMethod.OPTIONS)//OPTIONS 请求放行 也是解决跨域问题
                .permitAll()
                .and().formLogin().loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").permitAll()//让登陆页面任何情况能调用 设置参数名称
                .failureHandler(new org.springframework.security.web.authentication.AuthenticationFailureHandler() {//重写登陆失败结果 原来的是页面  有2种方式不够都大同小异  这是第一种匿名内部类
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                StringBuffer sb = new StringBuffer();
                sb.append("{\"code\":1,\"status\":\"error\",\"msg\":\"");
                if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                    sb.append("用户名或密码输入错误，登录失败!");
                } else if (e instanceof DisabledException) {
                    sb.append("账户被禁用，登录失败，请联系管理员!");
                } else {
                    sb.append("登录失败!");
                }
                sb.append("\"}");
                out.write(sb.toString());
                out.flush();
                out.close();
            }
        })
                .successHandler(new org.springframework.security.web.authentication.AuthenticationSuccessHandler() {//重写登陆失败结果 原来的是页面
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                ObjectMapper objectMapper = new ObjectMapper();
                String s = "{\"code\":0,\"status\":\"success\",\"msg\":" + objectMapper.writeValueAsString("登陆成功") + "}";
                out.write(s);
                out.flush();
                out.close();
            }
        })
                .and().exceptionHandling().authenticationEntryPoint(macLoginUrlAuthenticationEntryPoint())//处理未登陆就调用请求  这是第二种使用自定义的结果 创建一个类实现相应的接口然后注入bean容器 并配置在这里
                .and().logout().logoutSuccessHandler(userLogoutSuccessHandler()).permitAll()//处理自定义登出请求 同上
                .and().csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }

    @Bean
    public SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler();
    }

    @Bean
    public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandler();
    }

    @Bean
    public SimpleUrlLogoutSuccessHandler authenticationLogoutSuccessHandler() {
        return new AuthenticationLogoutSuccessHandler();
    }
    @Bean
    public UserLogoutSuccessHandler userLogoutSuccessHandler(){
        return new UserLogoutSuccessHandler();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityUserDetail);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    /**
     * 自定义 处理未登陆就调用请求
     * @return
     */
    @Bean
    public AuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint() {
        return new MacLoginUrlAuthenticationEntryPoint();
    }



//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//        return tokenRepository;
//    }

//Spring框架为CORS提供了一流的支持。CORS必须在Spring Security之前处理，因为飞行前请求不会包含任何cookie（即，JSESSIONID）。
// 如果请求中不包含任何cookie并且Spring Security是第一个
// ，则该请求将确定用户未被认证（因为请求中没有cookie）并拒绝它。
//
//确保首先处理CORS的最简单方法是使用CorsFilter。用户可以CorsFilter通过CorsConfigurationSource使用以下内容来集成Spring Security
    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}