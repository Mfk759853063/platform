package com.vbn.platform.config;

import com.vbn.platform.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by vbn on 2018/12/18.
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authticationInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public AuthenticationInterceptor authticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
