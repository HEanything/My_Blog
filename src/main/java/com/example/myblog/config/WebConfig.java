package com.example.myblog.config;

import com.example.myblog.interceptors.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginIntercepter loginIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginIntercepter).addPathPatterns("/**").excludePathPatterns("/api/user/register","/api/user/login","/api/Articles","/api/Articles/{articleId}",
                "/api/Articles/{ArticleId}/comments","/api/ArticlesAndLabel","/api/ArticlesAndLabel/{articleId}");
    }
}
