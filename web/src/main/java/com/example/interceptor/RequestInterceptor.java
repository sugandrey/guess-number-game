package com.example.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger("trace");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("PreHandle method called. Handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("PostHandle method called. Handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
        log.debug("ModelAndView = {}",modelAndView.getModel());
        log.debug("ModelAndView = {}",modelAndView.getViewName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("AfterCompletion method called. Handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
    }
}
