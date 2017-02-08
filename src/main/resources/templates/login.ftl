<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登录</title>
    <link href="css/common.css" rel="stylesheet" />
    <link href="css/login.css" rel="stylesheet"/>
</head>

<body>
<!--section-->
<div class="section">
    <div class="loginBack">
        <!--logo-->
        <p class="loginIcon"><img src="img/common/logo.png" alt=""/></p>
        <!--inputCon-->
        <div class="inputCon">
            <p class="loginYi">
                <input type="text" id="userName" placeholder="用户账号"/>
            </p>
            <div class="inputLine"><span></span><p></p><span></span></div>
            <p class="loginYi">
                <input type="password" id="passWord" placeholder="密码"/>
            </p>
        </div>
        <!--alert-->
        <p class="alertCon"><span class="errorAlert"><img src="img/common/errorAlert.png" alt=""/>密码错误！</span></p>
        <!--denglu -->
        <p class="btnCon"><a href="#"><button class="btn loginBtn">登录</button></a></p>
        <!--看看-->
        <p class="kan"><a href="${system.basePath}/index">我是访客，随便看看&gt;&gt;</a></p>
    </div>
</div>


<script src="js/jquery-1.11.3.js"></script>
<script>
    console.log( $('.loginYi input').val() );
    $('.section').css('height',window.screen.height +'px');


    $('.loginYi input').blur(function(){
        if($('.loginYi input').val()){
            $('.alertCon').css('display','block');
        }
    });


</script>

</body>
</html>



















