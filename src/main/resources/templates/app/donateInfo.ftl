<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>捐款结果</title>
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
        <p class="headerTitle">捐款结果</p>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="nullView">
        <img src="${system.basePath}/img/common/succeed01.png" alt="" style="width:72px;"/>
        <p class="succeed_zi">捐款成功</p>
        <p class="succeed_zi_sm">感谢您对本公益项目的支持和关注！</p>
    </div>
</div>
<!--foot-->
<div class="foot mui-row">
    <p class="mui-col-xs-6"><button id="kanDel">查看详情</button></p>
    <p class="mui-col-xs-6"><button class="footBack">返回首页</button></p>
</div>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script>
    $('.user').on('click',function(){
        window.history.back(-1);
    });
    $('#kanDel').on('click',function(){
        //window.location.href="mine_giftDel.html";
        var donorid='${donorid?if_exists}';
        window.location.href="${system.basePath}/app/queryDonorDeatail?donorid="+donorid+"&type=donor";
    });
    $('.footBack').on('click',function(){
        window.location.href="${system.basePath}/index";
    });
</script>
</body>

</html>