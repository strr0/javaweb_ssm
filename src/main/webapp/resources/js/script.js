/* 注册部分 */

/* 管理员注册 */
/*function adminChange(){
    var admin = document.getElementById("adminValue");
    var item = document.getElementById("admin");
    if(admin.value == 0){
        admin.value = 1;
        item.innerHTML = "注册管理员";
    }
    else{
        admin.value = 0;
        item.innerHTML = "注册用户";
    }
}*/
/* 判断用户名 */
function isName(value){
    var item = document.getElementById("name_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "用户名不能为空";
    }
    else if(value.length > 10 || value.length < 2){
        item.innerHTML = "长度必须为2-10位";
    }
    else{

        if(isExistName(value, item)){
            return false;
        }
        else{
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
    }
    return false;
}
/* 判断用户名是否存在 AJAX代码 */
function isExistName(value, item) {
    /*var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            var message = xmlhttp.responseText;
            if(message.indexOf("ok") != -1){
                item.style.color = "green";
                item.innerHTML = xmlhttp.responseText;
                return false;
            }
            else{
                item.style.color = "red";
                item.innerHTML = xmlhttp.responseText;
                return true;
            }
        }
    }
    xmlhttp.open("GET", "AjaxServlet?name=" + value, true);
    xmlhttp.send();*/
    //return true;
}
/* 判断真实姓名 */
function isRealName(value){
    var item = document.getElementById("real_name_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "真实姓名不能为空";
    }
    else if(value.length > 16 || value.length < 6){
        item.innerHTML = "长度必须为6-16位";
    }
    else{
        var index = value.search(/[^0-9a-zA-Z]/);
        if(index == -1){
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
        else{
            item.innerHTML = "必须用数字和字母的组合";
        }
    }
    return false;
}
/* 判断性别 */
function isSex(){
    var value = document.getElementsByName("sex");
    var item = document.getElementById("sex_error");
    item.style.color = "red";
    for(var i = 0; i < value.length; i++){
        if(value[i].checked){
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
    }
    item.innerHTML = "请选择性别";
    return false;
}
/* 判断年龄 */
function isAge(value){
    var item = document.getElementById("age_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "年龄不能为空";
    }
    else if(value >= 1 && value <= 150){
        item.style.color = "green";
        item.innerHTML = "ok!";
        return true;
    }
    else{
        item.innerHTML = "年龄必须为1-150之间";
    }
    return false;
}
/* 判断密码 */
function isPassword(value){
    var item = document.getElementById("password_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "密码不能为空";
    }
    else if(value.length > 18 || value.length < 6){
        item.innerHTML = "长度必须为6-18位";
    }
    else{
        var index = value.search(/[^0-9a-zA-Z]/);
        if(index == -1){
            item.innerHTML = "请确认密码";
            return true;
        }
        else{
            item.innerHTML = "必须用数字和字母的组合";
        }
    }
    return false;
}
/* 判断确认密码 */
function isConfirmPWD(value){
    var item_cf = document.getElementById("confirm_pwd_error");
    item_cf.style.color = "red";
    var item_pwd = document.getElementById("password_error");
    item_pwd.style.color = "red";
    if(value == ""){
        item_cf.innerHTML = "密码不能为空";
    }
    else if(value.length > 18 || value.length < 6){
        item_cf.innerHTML = "长度必须为6-18位";
    }
    else{
        var index = value.search(/[^0-9a-zA-Z]/);
        if(index == -1){
            var pwd = document.getElementById("pwd").value;
            if(pwd == value){
                item_cf.style.color = "green";
                item_cf.innerHTML = "ok!";
                item_pwd.style.color = "green";
                item_pwd.innerHTML = "ok!";
                return true;
            }
            else{
                item_cf.innerHTML = "请重新确认密码";
                item_pwd.innerHTML = "请重新确认密码";
            }
        }
        else{
            item.innerHTML = "必须用数字和字母的组合";
        }
    }
    return false;
}
/* 判断电话 */
function isTel(value){
    var item = document.getElementById("tel_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "电话号码不能为空";
    }
    else if(value.length != 11){
        item.innerHTML = "长度必须为11位";
    }
    else{
        var index = value.search(/[^0-9]/);
        if(index == -1){
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
        else{
            item.innerHTML = "电话号码必须为数字";
        }
    }
    return false;
}
/* 判断邮箱 */
function isEmail(value){
    var item = document.getElementById("email_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "邮箱不能为空";
    }
    else{
        var at = value.search(/@/);
        var com = value.search(/.com/);
        if(at == -1 || com == -1 || at == 0 || (com - at) < 2){
            item.innerHTML = "请输入合法邮箱";
        }
        else{
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
    }
    return false;
}
/* 判断爱好 */
function isLike(){
    var value = document.getElementsByName("likes");
    var item = document.getElementById("like_error");
    for(var i = 0; i < value.length; i++){
        if(value[i].checked){
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
    }
    item.style.color = "red";
    item.innerHTML = "请选择爱好";
    return false;
}
/* 判断个性签名 */
function isTag(value){
    var item = document.getElementById("tag_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "个性签名不能为空";
    }
    else{
        item.style.color = "green";
        item.innerHTML = "ok!";
        return true;
    }
    return false;
}
/* 判断表单是否填写完整 */
function formCheck(){
    var test1 = isName(document.getElementById("name").value);
    //var test2 = isRealName(document.getElementById("real_name").value);
    var test3 = isSex();
    var test4 = isAge(document.getElementById("age").value);
    var test5 = isPassword(document.getElementById("pwd").value);
    var test6 = isConfirmPWD(document.getElementById("confirm_pwd").value);
    //var test7 = isTel(document.getElementById("tel").value);
    //var test8 = isEmail(document.getElementById("email").value);
    var test9 = isLike();
    var test10 = isTag(document.getElementById("tag").value);
    return (test1 && test3 && test4 && test5 && test6 && test9 && test10);
}
function changeCheck() {
    var test4 = isAge(document.getElementById("age").value);
    var test5 = isPassword(document.getElementById("pwd").value);
    var test6 = isConfirmPWD(document.getElementById("confirm_pwd").value);
    var test9 = isLike();
    var test10 = isTag(document.getElementById("tag").value);
    return (test4 && test5 && test6 && test9 && test10);
}

/* 注册部分完毕 */

/* 登录部分 */

/* 登录部分完毕 */

/* 导航栏代码 */
function getLabel(id){
    return document.getElementById(id).getElementsByClassName("label_select");
}
for(var i = 0; i < getLabel("label").length; i++){
    getLabel("label")[i].onclick = function(){
        resetLabel();
        this.style.background = "#AAAACC";
    }
}
function resetLabel(){
    for(var i = 0; i < getLabel("label").length; i++)
    {
        getLabel("label")[i].style.background = '';
    }
}

/* 插入页面 */
/* GET方式获取页面 */
function insertPage(url){
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("demo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
/* POST方式获取页面 */
function postData(url, data){
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("demo").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST", url);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send(data);
}
/* 提交留言 */
function postMessage(){
    var data = document.getElementById("message_data").value;
    postData("addmessage", "data=" + data);
}
/* 删除留言 */
function deleteMessage(id){
    postData("deletemessage", "id=" + id);
}
/* 更新用户信息 */
function toUpdateUser(id) {
    insertPage("updateuser?id=" + id);
}
/* 删除用户 */
function toDeleteUser(id){
    postData("deleteuser", "id=" + id);
}
/* 注册用户 */
function insertUser(){
    $.ajax({
        type: "POST",
        url: "register",
        data: $('#register_form').serializeArray(),
        success: function(result) {
            console.log(result);//打印服务端返回的数据(调试用)
            alert("注册成功!");
            $(location).attr('href', 'main')
        },
        error : function() {
            alert("异常!");
        }
    });
}
function addUser(){
    if(formCheck()){
        insertUser();
    }
}
/* 修改用户 */
function updateUser(){
    $.ajax({
        type: "POST",
        url: "updateuser",
        data: $('#change_form').serializeArray(),
        success: function(result) {
            console.log(result);//打印服务端返回的数据(调试用)
            alert("修改成功!");
            $(location).attr('href', 'main')
        },
        error : function() {
            alert("异常!");
        }
    });
}
function changeUser(){
    if(changeCheck()){
        updateUser();
    }
}

/* 角色管理 */
function isRoleName(value){
    var item = document.getElementById("name_error");
    item.style.color = "red";
    if(value == ""){
        item.innerHTML = "角色名不能为空";
    }
    else if(value.length > 10 || value.length < 2){
        item.innerHTML = "长度必须为2-10位";
    }
    else{
        item.style.color = "green";
        item.innerHTML = "ok!";
        return true;
    }
    return false;
}
function isPermission(){
    var value = document.getElementsByName("permissions");
    var item = document.getElementById("permission_error");
    for(var i = 0; i < value.length; i++){
        if(value[i].checked){
            item.style.color = "green";
            item.innerHTML = "ok!";
            return true;
        }
    }
    item.style.color = "red";
    item.innerHTML = "请选择权限";
    return false;
}
function roleFormCheck() {
    var test1 = isRoleName(document.getElementById("name").value);
    var test2 = isPermission();
    return (test1 && test2);
}
function ajaxPostData(url, form_id){
    $.ajax({
        type: "POST",
        url: url,
        data: $(form_id).serializeArray(),
        success: function(result) {
            console.log(result);//打印服务端返回的数据(调试用)
            alert("修改成功!");
            $(location).attr('href', 'main')
        },
        error : function() {
            alert("异常!");
        }
    });
}
function roleAdd() {
    if(roleFormCheck()){
        ajaxPostData("roleadd", "#role_form");
    }
}
/* 删除角色 */
function toDeleteRole(name){
    postData("roledelete", "name=" + name);
}
/* 修改角色 */
function toUpdateRole(name){
    insertPage("rolechange?name=" + name);
}
function upDateRole(){
    if(roleFormCheck()){
        ajaxPostData("rolechange", "#role_form");
    }
}