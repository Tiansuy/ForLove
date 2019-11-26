<%--
  Created by IntelliJ IDEA.
  User: 肖万
  Date: 2019/11/24
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript">
        // 验证输入不为空的脚本代码
        function checkForm(form) {
            if (form.id.value == "") {
                alert("学号不能为空!");
                form.id.focus();
                return false;
            }
            if (form.pwd.value == "") {
                alert("密码不能为空!");
                form.pwd.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div style="text-align: center;margin: 0px auto;">
<form action="RegisterServlet" method="post" style="padding-top:-700px;" onsubmit="return checkForm(this);">
    输入学号:<input name="id" type="text" ><br><br>
    输入密码:<input name="pwd" type="password"><br><br>
    输入姓名:<input name="name" type="text"><br><br>
    输入用户名:<input name="uid" type="text"><br><br>
    个人说明:<input name="info" type="text"><br><br>

    <input type="reset"value="重置"><input type="submit"value="注册">
</form>
</div>
</body>
</html>
