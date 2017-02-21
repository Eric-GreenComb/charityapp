<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>区块详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath?if_exists}/css/mui.min.css">
    <link href="${system.basePath?if_exists}/css/common.css" rel="stylesheet">
    <link href="${system.basePath?if_exists}/css/mine_gift.css" rel="stylesheet">
</head>
<body>

<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath?if_exists}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">区块详情</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section ">
            <ul class="giftDel mui-table-view pzDelUl">
                <li class="mui-table-view-cell over">
                    <div>区块#${heigh?if_exists}</div>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">时间戳</p>
                    <p class="pzDel">${blockInfo.blockGenTime?if_exists}</p>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">世界态哈希</p>
                    <p class="pzDel">${blockInfo.stateHash?if_exists}</p>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">上一区块</p>
                    <p class="pzDel">${blockInfo.previousBlockHash?if_exists}</p>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">UUID</p>
                    <p class="pzDel">000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f[fake]</p>
                </li>
            </ul>
        </div>
    </div>
</div>


<script src="${system.basePath?if_exists}/js/mui.min.js"></script>
<script src="${system.basePath?if_exists}/js/jquery-1.11.3.js"></script>

<script>

    $('.user').on('tap',function(){
        window.history.back(-1);
    });

    mui('#offCanvasContentScroll').scroll();


</script>
</body>

</html>