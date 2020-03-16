//获取项目根路径
var contextpath = $("#contextpath").prop("src");
layui.config({
    base: contextpath //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块  index.js
}).use(['layer', 'jquery', 'element', 'index'], function () {
    var element = layui.element;
    var $ = layui.jquery;
    var layer = layui.layer;
    var index = layui.index;

    window.forward = function (path, name) {
        debugger
        if (name == 'index') {
            index.openTabsPage(path, "<i class='layui-icon layui-icon-home'></i>", false)
        } else {
            index.openTabsPage(contextpath + path, name)
        }
    }


});
