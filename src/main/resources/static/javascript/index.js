//获取项目根路径
var contextpath = $("#contextpath").prop("src");debugger
layui.config({
    base: '../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['layer', 'jquery', 'element', 'index'], function () {
    var element = layui.element;
    var $ = layui.jquery;
    var layer = layui.layer;
    var index = layui.index;

    // window.forward = function (path, name) {
    //     if (name == 'index') {
    //         index.openTabsPage(path, "<i class='layui-icon layui-icon-home'></i>", false)
    //     } else {
    //         index.openTabsPage(contextpath + path, name);
    //     }
    // }

    window.forward = function (path,name) {
        if(name=='index'){
            index.openTabsPage(path, "<i class='layui-icon layui-icon-home'></i>",false)
        }else{
            index.openTabsPage(context + path, name)
        }
    }
});
