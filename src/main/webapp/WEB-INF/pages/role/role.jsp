<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="blank"></div>
<div style="float: right; margin-right: 10px;">
    <a href="logout">注销</a>
</div>
<c:set var="adminName" value="${sessionScope.nameKey}"></c:set>
<div class="input_item">
    <font size="5"> 欢迎登录, ${adminName} </font>
</div>
<div class="show_item">
    <c:if test="${!empty roles}">
        角色列表
        <table border="1">
            <tr>
                <th style="width: 80px;">角色名</th>
                <th style="width: 80px;">个人信息</th>
                <th style="width: 80px;">留言板</th>
                <th style="width: 80px;">所有用户</th>
                <th style="width: 80px;">角色管理</th>
                <th style="width: 80px;">
                    <button class="bt_user_add" onclick="insertPage('roleadd')">添加角色</button>
                </th>
            </tr>
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td><c:out value="${role.name}"></c:out></td>
                    <td>${role.permissions.contains('个人信息') ? '✔':''}</td>
                    <td>${role.permissions.contains('留言板') ? '✔':''}</td>
                    <td>${role.permissions.contains('所有用户') ? '✔':''}</td>
                    <td>${role.permissions.contains('角色管理') ? '✔':''}</td>
                    <td>
                        <div style="overflow: hidden; width: 80px;">
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_change" onclick="toUpdateRole('${role.name}')">修改</button>
                            </div>
                            <div style="float: left; width: 40px;">
                                <button class="bt_user_delete" onclick="toDeleteRole('${role.name}')">删除</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${!empty message}">
        ${message}
    </c:if>
</div>
</body>
</html>
