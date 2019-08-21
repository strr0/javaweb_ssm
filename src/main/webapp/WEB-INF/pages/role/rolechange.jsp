<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21
  Time: 13:35
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
<div style="float: right; margin-right: 10px;"><a href="main">返回</a></div>
<c:if test="${!empty roleKey}">
    <form id="role_form">
        <div class="input_item">
            <font size="5">修改角色</font>
        </div>
        <div class="input_item">
            <div class="input_field">角色名：</div>
            <div class="input_field"><input type="text" id="name" name="name" value="${roleKey.name}" readonly /></div>
            <div class="input_error" id="name_error"></div>
        </div>
        <%-- permissions为用户所拥有的权限 --%>
        <c:set var="permissions" value="${roleKey.permissions}"></c:set>
        <div class="input_item">
            <div class="input_field">角色权限：</div>
            <div class="input_field">
                <%-- permission为数据库中某一个权限 --%>
                <c:forEach var="permission" items="${permissionKey}">
                    <div>
                        ${permission.description}<input type="checkbox" name="permissions" onchange="isPermission()" value="${permission.name}" ${permissions.contains(permission.description) ? 'checked' : ''} />
                    </div>
                </c:forEach>
            </div>
            <div class="input_error" id="permission_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">
                <input type="button" class="bt1" value="注册" onclick="upDateRole()" />
            </div>
            <div class="input_field">
                <input type="button" class="bt1" onclick="" value="取消" />
            </div>
        </div>
    </form>
</c:if>


</body>
</html>
