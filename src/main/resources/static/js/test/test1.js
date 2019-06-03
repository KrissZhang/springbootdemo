/**
 * test1.js
 */

/**
 * 测试ajax
 */
function testAjax() {
    $.ajax({
        type:"GET",
        dataType:"json",
        async:false,
        url:common.contextPath + "/admin/testInfo/queryTestInfo",
        data:{
            id:3
        },
        success:function(data){
            $("#td1").html(data.data.id);
            $("#td2").html(data.data.name);
            $("#td3").html(data.data.value);
        },
        error:function(data){
            alert(data);
        }
    });
}