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
    }

}

var common = new commonClass();