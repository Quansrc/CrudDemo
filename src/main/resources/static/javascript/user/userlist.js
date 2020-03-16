var contextpath = $("#contextpath").prop("src");
layui.use('table', function () {
    var table = layui.table;

    function getIsDeleteName(status) {
        if (status == "0") {
            return "存在";
        } else if (status == "1") {
            return "删除";
        }
    }

    //第一个实例
    table.render({
        elem: '#userlist'
        , height: 312
        , url: contextpath + 'user/userlist' //数据接口
        , page: true //开启分页
        , limit: 1
        , cols: [[ //表头
            {field: 'id', title: 'ID', width: 150, sort: true, fixed: 'left'}
            , {field: 'name', title: '姓名', width: 150}
            , {field: 'password', title: '密码', width: 150, sort: true}
            , {field: 'IsDelete', title: '是否有效', width: 150,templet:function (rows) {debugger
                    return getIsDeleteName(rows.isDelete);
                }}
        ]]
    });

});
