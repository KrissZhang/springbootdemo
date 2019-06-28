package com.self.springbootdemo.constant;

/**
 * 系统常量
 * @author zp
 */
public final class SysConstant {

    /**
     * 系统当前版本
     */
    public static final String SYS_VERSION = "1.0";

    /**
     * 系统默认编码
     */
    public static final String SYS_DEFAULT_ENCODING = "UTF-8";

    /**
     * 系统默认语言
     */
    public static final String SYS_DEFAULT_LANGUAGE = "zh";

    /**
     * 英语
     */
    public static final String SYS_ENGLISH = "en";

    /**
     * 系统语言包文件夹名称
     */
    public static final String SYS_LANGUAGE_PACKAGE = "languages";

    /**
     * 系统路径名
     */
    public static final String SYS_PATH_NAME = "springbootdemo";

    /**
     * 系统properties文件后缀
     */
    public static final String SYS_SUFFIX = "properties";

    /**
     * 点
     */
    public static final String SYS_DOT = ".";

    /**
     * 斜杠
     */
    public static final String SYS_SLASH = "/";

    /**
     * 下划线
     */
    public static final String SYS_UNDERLINE = "_";

    /**
     * 系统配置文件名
     */
    public static final String SYS_CFG_NAME = SYS_PATH_NAME + SYS_DOT + SYS_SUFFIX;

    /**
     * 登录重定向url
     */
    public static final String SYS_LOGIN_REDIRECT_URL = SYS_SLASH + SYS_PATH_NAME + "/login/toLoginPage";

    /**
     * 登录页url
     */
    public static final String SYS_LOGIN_PAGE_URL = SYS_SLASH + SYS_PATH_NAME + "/pages/common/login.html";

}
