<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
    <title></title>--%>
</head>
<body>

<%--<div class="box">--%>
    <div class="blank"></div>
    <div style="float: right; margin-right: 10px;"><a href="main">返回</a></div>
    <form id="register_form">
        <div class="input_item">
            <font size="5">注册用户</font>
        </div>
        <div class="input_item">
            <div class="input_field">用户名：</div>
            <div class="input_field"><input type="text" id="name" name="username" onblur="isName(this.value)" placeholder="请输入用户名" autocomplete="off" /></div>
            <div class="input_error" id="name_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">性别：</div>
            <div class="input_field">
                <input type="radio" name="sex" value="男" onchange="isSex()">男</input>
                <input type="radio" name="sex" value="女" onchange="isSex()">女</input>
            </div>
            <div class="input_error" id="sex_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">年龄：</div>
            <div class="input_field"><input type="text" id="age" name="age" onblur="isAge(this.value)" placeholder="请输入年龄" autocomplete="off" /></div>
            <div class="input_error" id="age_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">密码：</div>
            <div class="input_field"><input type="password" id="pwd" name="password" onblur="isPassword(this.value)" placeholder="请输入密码" autocomplete="off" /></div>
            <div class="input_error" id="password_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">确认密码：</div>
            <div class="input_field"><input type="password" id="confirm_pwd" name="confirmpwd" onblur="isConfirmPWD(this.value)" placeholder="请确认密码" autocomplete="off" /></div>
            <div class="input_error" id="confirm_pwd_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">爱好：</div>
            <div class="input_field">
                <input type="checkbox" name="likes" value="撩妹" onchange="isLike()">撩妹</input>
                <input type="checkbox" name="likes" value="写代码" onchange="isLike()">写代码</input>
                <input type="checkbox" name="likes" value="篮球" onchange="isLike()">篮球</input>
                <input type="checkbox" name="likes" value="足球" onchange="isLike()">足球</input>
            </div>
            <div class="input_error" id="like_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">个性签名：</div>
            <div class="input_field"><textarea form="register_form" id="tag" name="tag" onblur="isTag(this.value)" placeholder="请输入个性签名" autocomplete="off"></textarea></div>
            <div class="input_error" id="tag_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">用户类型：</div>
            <div class="input_field">
                <c:set var="roles" value="${rolesKey}"></c:set>
                <c:if test="${!empty roles}" var="flag">
                    <select form="register_form" name="usertype">
                        <c:forEach var="role" items="${roles}">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </c:if>
                <c:if test="${not flag}">
                    空类型
                </c:if>
            </div>
            <div class="input_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">
                <input type="button" class="bt1" value="注册" onclick="addUser()" />
            </div>
            <div class="input_field">
                <input type="button" class="bt1" onclick="" value="取消" />
            </div>
        </div>
    </form>
    <div class="blank"></div>
<%--</div>--%>

<%--<script src="resources/js/script.js"></script>--%>
</body>
</html>


