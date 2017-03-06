<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>

<div class="regAll">
    <p class="regBack"><img src="${system.basePath}/img/common_admin/registerBack2.png" alt=""/></p>
    <div class="regTxtAll">
        <p class="regTxt">公益捐款·商户版</p>
        <!--inputCon-->
        <div class="inputCon">
            <p class="loginYi loginYiName">
                <input type="text" id="userName" id="userName" value="fund01" readonly placeholder="用户账号"/>
            </p>
            <div class="inputLine"><span></span><p></p><span></span></div>
            <p class="loginYi">
                <input type="password" id="passWord" value="000000" placeholder="密码"/>
            </p>
        </div>
        <!--alert-->
        <p class="alertCon"><span class="errorAlert"><img src="${system.basePath}/img/common_admin/errorAlert.png" alt=""/>您的账号或密码输入有误，请重新输入。</span></p>
        <!--denglu -->
        <p class="btnCon"><a href="#"><button class="btn loginBtn">登录</button></a></p>
    </div>
</div>

<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/admin/common_admin.js"></script>

<script>
 $('.loginBtn').bind("click", function(){  
	   var userName =$("#userName").val();
        window.location.href="${system.basePath}/admin/login_login?userName="+userName;
	}); 
</script>
</body>
</html>