<%--
  Created by IntelliJ IDEA.
  User: 肖万
  Date: 2019/11/24
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.cn.model.UserModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cn.dao.UserDao" %>
<%@ page import="com.cn.dao.UserDaoImpl" %>
<%@ page import="java.lang.ref.ReferenceQueue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ALL</title>
</head>
<body style="text-align: center">
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>
<!-- 使用from提交数据，不能在不刷新页面的情况下直接在当前页面显示处理过的后台数据-->
<div style="text-align: center;margin: 0 auto " >
<tr>
    <td align="center"><input type="text" value="ID" disabled></td>
    <td align="center"><input value="姓名" type="text" name=""disabled></td>
    <td align="center"><input value="密码" type="text" name="" disabled></td>
    <td align="center"><input value="个人说明" type="text" name="" disabled></td>
    <td align="center"><input value="可执行操作" type="text" name="" disabled></td>
</tr>
<c:forEach var="U" items="${requestScope.all}"  >
    <div style="margin: 0px auto">
    <form action="UpdateServlet" method="post">
        <tr align="center">
            <td><input type="text" value="${U.id}" name="id" readonly></td>
            <td><input type="text" value="${U.name}" name="name" ></td>
            <td><input type="text" value="${U.password}" name="password"></td>
            <td><input type="text" value="${U.info}" name="info"></td>
            <td><a href="DeleteServlet?id=${U.id}">删除</a> <input type="submit" value="更新"/></td>
        </tr>
    </form>
    </div>
</c:forEach>
</div>
<p align="center" style="color: #0096e6">
    当前update只能根据ID修改name，懒得做其他内容了<br>
    目录栏用的input状态disabled不发送数据<br>
    ID栏readonly防止修改ID逻辑错误<br>
    只做了大概框架，以后再补吧！<br>
    稀巴烂<br>
</p>
</body>
</html>
