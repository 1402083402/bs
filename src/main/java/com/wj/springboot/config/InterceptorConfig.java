package com.wj.springboot.config;

import com.wj.springboot.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns("/user/login", "/user/register", "/**/export", "/**/import", "/file/**",
                        "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/api", "/api-docs", "/api-docs/**","/captcha/**","/slide","/img/**","/index/**")
                .excludePathPatterns( "/**/*.html", "/**/*.js", "/**/*.css", "/**/*.woff", "/**/*.ttf","/**/*.png","/static/**","/sliderimage/**");  // 放行静态文件

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //1、添加资源处理器路径 即每次访问静态资源都得添加"/static/",例如localhost:8080/static/j1.jpg
        //若registry.addResourceHandler("/s/**") 则必须访问localhost:8080/s/j1.jpg
        registry.addResourceHandler("/static/**")
                //2、添加了资源处理器路径后对应的映射资源路径
                .addResourceLocations("classpath:/static/");
    }
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
