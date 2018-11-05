<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" name="userName" placeholder="账号"/><br>
    <input type="text" name="password" placeholder="密码"/><br>
    <input type="button" id="login" value="提交"/>

    <script src="/js/jquery-3.3.1.min.js"></script>
    <script>
        $("#login").click(function () {
            $.ajax({
                type:"get",
                url:"/login",
                data:{"username":$("input[name='userName']").val(),"password":$("input[name='password']").val()},
                success:function (data) {
                    if(data.msg == "ok"){
                        alert("登入成功");
                        window.location.href = "/index";
                    }else {
                        alert("登入失败");
                    }
                }
            });
        });
    </script>
</body>
</html>
