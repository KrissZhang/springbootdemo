/**
 * 通用方法类
 */
function commonClass() {

}

commonClass.prototype = {
    /**
     * contextPath
     */
    contextPath:"/springbootdemo",

    /**
     * 测试方法
     * @param data data
     * @returns data
     */
    test:function (data) {
        return data;
    },

    /**
     * 加载页面
     * @param url 请求视图url
     */
    loadPage:function (url) {
        url = this.contextPath + url;
        $("html").load(url);
    }

}

var common = new commonClass();