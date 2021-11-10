package com.florence.resources.config;

import com.florence.resources.interceptors.RightToViewInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wuyanzhen
 */
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    RightToViewInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**");
    }
}
