<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>捐款记录--null</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
</head>
<body>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">捐款记录</p>
    </div>
</div>
<!--section-->
<div class="nullView">
    <img src="${system.basePath}/img/common/contributeNull.png" alt="" style="width:113px;"/>
    <p class="nullView_zi">您还没有任何捐款记录~</p>
    <p class="nullAct"><a href="#"><button class="btn footBack">我要捐款</button></a></p>
</div>

</body>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script>
    $('.user').on('click',function(){
        window.history.back(-1);
    });
    
     $('.footBack').on('click',function(){
        window.location.href="${system.basePath}/index";
    });
</script>
</html>