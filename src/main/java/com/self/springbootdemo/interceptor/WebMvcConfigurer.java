package com.self.springbootdemo.interceptor;

import cn.hutool.core.util.CharsetUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

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
     * 响应编码处理
     * @param converters converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(Charset.forName(CharsetUtil.UTF_8)));
    }

    /**
     * 处理静态资源
     * @param registry registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 设置首页
     * @param registry registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        super.addViewControllers(registry);
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
