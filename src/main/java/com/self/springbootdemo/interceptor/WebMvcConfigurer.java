package com.self.springbootdemo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 拦截配置
 * @author zp
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * 跨域拦截配置
     * @param registry registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);

        super.addCorsMappings(registry);
    }

    /**
     * 处理静态资源
     * @param registry registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加自定义拦截器
     * @param registry registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //按照拦截器的声明顺序执行(表达式指向请求方法的url，* 和 ** 代表全部)
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}
