package com.nikang.client.config.Interceptors;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * All rights Reserved, Designed By www.faw.com.cn
 * @Title:  MyInterceptor.java   
 * @Package com.faw.toccore.config.interceptor   
 * @Description:TODO类描述
 * @since JDK 1.8
 * @author liaoming
 * @Email 15926257087@139.com
 * @version: v1.0.0
 * @date: 2019年10月28日 下午3:38:08 
 * @Copyright: 2019 www.faw.com.cn Inc. All rights reserved. <br/> 
 * 注意：本内容仅限于一汽集团内部传阅，禁止外泄以及用于其他的商业目的<br/> 
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put("traceId",UUID.randomUUID().toString().replaceAll("-", ""));
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
    
    
}
