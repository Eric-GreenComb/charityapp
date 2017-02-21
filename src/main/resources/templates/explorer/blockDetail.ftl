<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="UTF-8">
    <title>区块详情</title>
    <link rel="stylesheet" href="${system.basePath?if_exists}/css/common_pc.css"/>
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath?if_exists}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
            <p class="search_con">
                <input type="text" id="search" class="search" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="#"><img src="${system.basePath?if_exists}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <div class="partYi">
            <p class="partName">区块#${heigh}</p>
            <p class="partInfo"><span>时间戳</span><span>${blockInfo.blockGenTime?if_exists}</span></p>
            <p class="partInfo"><span>世界态哈希</span><span>${blockInfo.stateHash?if_exists}</span></p>
            <p class="partInfo"><span>上一区块</span><span>${blockInfo.previousBlockHash?if_exists}</span></p>
        </div>
    </div>
</div>


<script src="${system.basePath?if_exists}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath?if_exists}/js/common_pc.js"></script>
</body>
</html>