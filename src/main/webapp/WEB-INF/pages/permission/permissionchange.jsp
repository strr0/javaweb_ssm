<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 8:25
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
<form id="change_form">
    <div class="input_item">
        <font size="5">修改权限</font>
    </div>
    <div class="input_item">
        <div class="input_field">权限名：</div>
        <div class="input_field">
            <input type="text" id="name" name="name" onblur="isPermissionName(this.value)" value="${permissionKey.name}" readonly />
        </div>
        <div class="input_error" id="name_error"></div>
    </div>
    <div class="input_item">
        <div class="input_field">权限描述：</div>
        <div class="input_field">
            <input type="text" id="description" name="description" onblur="isDescription(this.value)" value="${permissionKey.description}" />
        </div>
        <div class="input_error" id="description_error"></div>
    </div>
    <div class="input_item">
        <div class="input_field">url地址：</div>
        <div class="input_field">
            <input type="text" id="url" name="url" onblur="isUrl(this.value)" value="${permissionKey.url}" />
        </div>
        <div class="input_error" id="url_error"></div>
    </div>
    <div class="input_item">
        <div class="input_field">
            <input type="button" class="bt1" value="注册" onclick="postChangePermissionForm()" />
        </div>
        <div class="input_field">
            <input type="button" class="bt1" onclick="" value="取消" />
        </div>
    </div>
</form>
</body>
</html>
