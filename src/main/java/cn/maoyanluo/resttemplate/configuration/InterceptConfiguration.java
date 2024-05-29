package cn.maoyanluo.resttemplate.configuration;

import cn.maoyanluo.resttemplate.intercept.LoginStatusIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginStatusIntercept())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/**");

    }
}
