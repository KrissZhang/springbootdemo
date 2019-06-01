package com.self.springbootdemo.i18n;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import com.self.springbootdemo.constant.SysConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 语言配置
 * @author zp
 */
public class I18nUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(I18nUtil.class);

    /**
     * 语言集
     */
    private static final Map<String,Props> ALL_MAPPING = new HashMap<>();

    /**
     * 当前语言包
     */
    private static Props currentMapping = new Props();

    /**
     * 当前语言标识
     */
    private static String languageKey = SysConstant.SYS_DEFAULT_LANGUAGE;

    //加载语言包
    static {
        try {
            //英语
            loadOneLanguagePackage(SysConstant.SYS_ENGLISH);

            //中文
            loadOneLanguagePackage(SysConstant.SYS_DEFAULT_LANGUAGE);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /**
     * 加载某一种语言包
     * @param lang 语言标识
     */
    private static void loadOneLanguagePackage(String lang){
        String path = SysConstant.SYS_LANGUAGE_PACKAGE + SysConstant.SYS_SLASH + lang + SysConstant.SYS_DOT + SysConstant.SYS_SUFFIX;
        Props props = new Props(path);
        ALL_MAPPING.put(lang,props);
    }

    /**
     * 初始化语言
     * @param lang 语言标识(zh--中文,en--英文)
     */
    public static void setLanguage(String lang){
        if(StrUtil.isBlank(lang)){
            lang = SysConstant.SYS_DEFAULT_LANGUAGE;
        }

        languageKey = lang;

        currentMapping = ALL_MAPPING.get(languageKey);
    }

    /**
     * 在当前语言环境下获取语言信息
     * @param code code
     * @return msg
     */
    public static String get(String code){
        if(currentMapping == null){
            currentMapping = ALL_MAPPING.get(languageKey);
        }

        return currentMapping.getProperty(code);
    }

}
