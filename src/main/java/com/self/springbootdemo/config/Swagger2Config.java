package com.self.springbootdemo.config;

import com.self.springbootdemo.constant.SysConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 * @author zp
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 创建RestApi
     * @return 摘要
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.self.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置API文档详细信息
     * @return API文档详细信息
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springbootdemo 接口文档")
                .contact(new Contact(SysConstant.SYS_AUTHOR, SysConstant.SYS_AUTHOR_GITHUB, SysConstant.SYS_AUTHOR_EMAIL))
                .version(SysConstant.SYS_VERSION)
                .description("springbootdemo 接口文档")
                .build();
    }

}
