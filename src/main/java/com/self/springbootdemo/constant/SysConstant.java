package com.self.springbootdemo.constant;

/**
 * 系统常量
 * @author zp
 */
public final class SysConstant {

    /**
     * 系统当前版本
     */
    public static final String SYS_VERSION = "1.0.0";

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
     * 系统GeoLite包文件夹名称
     */
    public static final String SYS_GEOLITE_PACKAGE = "geolite";

    /**
     * 系统路径名
     */
    public static final String SYS_PATH_NAME = "springbootdemo";

    /**
     * 系统properties文件后缀
     */
    public static final String SYS_SUFFIX = "properties";

    /**
     * 系统mmdb文件后缀
     */
    public static final String SYS_MMDB = "mmdb";

    /**
     * 未知ip
     */
    public static final String SYS_IP_UNKNOWN = "unKnown";

    /**
     * 本机ip
     */
    public static final String SYS_IP_LOCAL = "127.0.0.1";

    /**
     * 系统作者
     */
    public static final String SYS_AUTHOR = "zp";

    /**
     * 系统作者github
     */
    public static final String SYS_AUTHOR_GITHUB = "https://github.com/KrissZhang";

    /**
     * 系统作者邮箱
     */
    public static final String SYS_AUTHOR_EMAIL = "273629304@qq.com";

    /**
     * 点
     */
    public static final String SYS_DOT = ".";

    /**
     * 逗号
     */
    public static final String SYS_COMMA = ",";

    /**
     * 斜杠
     */
    public static final String SYS_SLASH = "/";

    /**
     * 下划线
     */
    public static final String SYS_UNDERLINE = "_";

    /**
     * GeoLite国家
     */
    public static final String SYS_GEOLITE_COUNTRY = "GeoLite2-Country";

    /**
     * GeoLite城市
     */
    public static final String SYS_GEOLITE_CITY = "GeoLite2-City";

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
