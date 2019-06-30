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
        //拦截swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        //拦截其他资源
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

        //拦截请求前台接口的未登录用户
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/front/**", "/file/**");

        super.addInterceptors(registry);
    }

}
