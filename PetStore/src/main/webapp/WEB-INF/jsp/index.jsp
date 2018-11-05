<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World! 欢迎来到宠物商店！！！</h2>
<div style="width: 500px;height: 500px;border: 1px solid black">
    <table>
        <tr>
            <td>名字:</td>
            <td><input hidden="hidden" name="id" type="text"/><input name="name" type="text" placeholder="名称"/></td>
        </tr>
        <tr>
            <td>价格:</td>
            <td><input name="price" type="number" placeholder="价格"/></td>
        </tr>
        <tr>
            <td>宠物类型:</td>
            <td>
                <select name="type">
                    <option>--选择类型--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>宠物性格:</td>
            <td><input type="text" name="tag" placeholder="性格"/></td>
        </tr>
        <tr>
            <td>状态:</td>
            <td>
                <select name="status">
                    <option>--选择类型--</option>
                    <option value="可用">可用</option>
                    <option value="待定">待定</option>
                    <option value="已售出">已售出</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>图片：</td>
            <td hidden="hidden" id="img"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form id="uploadPic" action="#" method="post" enctype="multipart/form-data">
                    <input type="file" name="file"/><br><br>
                    <input type="button" id="uplocaimg" value="上传"/>
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" id="btn_add" value="添加"/> <input type="button" id="update" value="修改"/>
            </td>
        </tr>
    </table>
    <img id="imgShow" src="">
</div>
<table style="width: 700px;text-align: center">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>图片</th>
        <th>价格</th>
        <th>类型</th>
        <th>性格标签</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <tbody id="tbody"></tbody>
</table>

<script src="/js/jquery-3.3.1.min.js"></script>
<script>
    var list = function () {

        $("#tbody tr").remove();
        //查询出所有的宠物
        $.ajax({
            type: "get",
            url: "/pet/selectAll",
            success: function (data) {
                var tbody = $("#tbody");
                $.each(data, function (index, obj) {
                    tbody.append($("<tr>" +
                        "<td>" + obj.petId + "</td>" +
                        "<td>" + obj.petName + "</td>" +
                        "<td><img width='25pxp' height='30px' src='/img/" + obj.photo + "'/></td>" +
                        "<td>" + obj.petPrice + "</td>" +
                        "<td>" + obj.category.categoryName + "</td>" +
                        "<td>" + obj.tagName + "</td>" +
                        "<td>" + obj.petStatus + "</td>" +
                        "<td><button id='" + obj.petId + "' class='update'>修改</button> <button id='" + obj.petId + "' class='del'>删除</button></td>" +
                        "</tr>"));
                });
            }
        });


    }
    list();

    //把所有宠物的类型列出来
    $.ajax({
        type: "get",
        url: "/pet/selAllCategory",
        success: function (data) {
            var sel = $("select[name='type']");
            $.each(data, function (index, obj) {
                sel.append($("<option value='" + obj.categoryId + "'>" + obj.categoryName + "</option>"))
            });
        }
    });

    //添加宠物
    $("#btn_add").click(function () {

        var name = $("input[name='name']").val();
        var price = $("input[name='price']").val();
        var type = $("select[name='type']").val();
        var tag = $("input[name='tag']").val();
        var status = $("select[name='status']").val();
        var img = $("#img").html();

        $.ajax({
            url: "/pet/add",
            type: "post",
            data: {
                "petName": name,
                "petPrice": price,
                "categoryId": type,
                "tagName": tag,
                "petStatus": status,
                "photo": img
            },
            success: function (data) {
                if (data.msg == "success") {
                    alert("添加成功");
                    list();
                } else
                    alert(data.msg);
            }
        });
    });

    //图片上传
    $("#uplocaimg").click(function () {
        var formData = new FormData($("#uploadPic")[0]);
        $.ajax({
            type: "POST",
            url: "/pet/image",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                if (data.false == undefined) {
                    $("#img").html(data.true);
                    $("#imgShow").attr("src", "/img/" + data.true);
                }
                else {
                    alert(data.false);
                }
            }
        });
    });

    //获取修改宠物信息
    $("#tbody").on("click", '.update', function () {
        var id = $(this).prop("id");
        $.ajax({
            type: "get",
            url: "/pet/selectById",
            data: {"id": id},
            success: function (data) {
                console.log(data)
                $("input[name='id']").val(data.petId);
                $("input[name='name']").val(data.petName);
                $("input[name='price']").val(data.petPrice)
                $.each($("select[name='type'] option"), function (index, obj) {
                    if ($(obj).val() == data.categoryId) {
                        $(this).attr("selected", true);
                    }
                });
                $("#img").html(data.photo);
                $("#imgShow").attr("src", "/img/" + data.photo);
                $("input[name='tag']").val(data.tagName);
                $.each($("select[name='status'] option"), function (index, obj) {
                    if ($(obj).val() == data.petStatus) {
                        $(this).attr("selected", true);
                    }
                });
            }
        })
    })

    //修改宠物信息
    $("#update").click(function () {
        var id = $("input[name='id']").val();
        var name = $("input[name='name']").val();
        var price = $("input[name='price']").val();
        var type = $("select[name='type']").val();
        var tag = $("input[name='tag']").val();
        var status = $("select[name='status']").val();
        var img = $("#img").html();

        console.log(id, name, price, type, tag, status, img);

        $.ajax({
            url: "/pet/update",
            type: "post",
            data: {
                "petId": id,
                "petName": name,
                "petPrice": price,
                "categoryId": type,
                "tagName": tag,
                "petStatus": status,
                "photo": img
            },
            success: function (data) {
                if (data.msg == "success") {
                    alert("修改成功");
                    list();
                } else
                    alert(data.msg);
            }
        });
    });
    //删除宠物
    $("#tbody").on("click",".del",function () {
        var id = $(this).prop("id")
        if(confirm("你确定删除吗？")){
            $.ajax({
                type:"get",
                url:"/pet/del",
                data:{"petId":id},
                success:function (data) {
                    if(data.msg=="success"){
                        alert("删除成功");
                        list();
                    }else{
                        alert(data.msg);
                    }
                }
            })
        }
    })
</script>
</body>
</html>
