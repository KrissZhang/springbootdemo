package com.self.springbootdemo;

import cn.hutool.setting.dialect.Props;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.i18n.I18nUtil;
import com.self.springbootdemo.util.GeoLite2Util;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 * @author zp
 */
@SpringBootApplication
@MapperScan("com.self.springbootdemo.dao")
@EnableCaching
public class SpringbootdemoApplication extends SpringBootServletInitializer implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    /**
     * 打包项目
     * @param builder builder
     * @return 打包项目
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    /**
     * 启动加载方法
     * @param args args
     * @throws Exception Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //加载语言包
        I18nUtil.setLanguage(new Props(SysConstant.SYS_CFG_NAME).get("language").toString());

        //加载GeoLite2
        GeoLite2Util.geoLite2Init();

        System.out.println("启动成功");
    }

}
