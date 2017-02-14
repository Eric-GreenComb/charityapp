<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="UTF-8">
    <title>交易详情</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_pc.css"/>
</head>
<body>

<!--mask-->
<div class="dealDel">
    <div class="dealMask">
        <p class="dealTitle">合约详情</p>
        <p class="maskColor"></p>
        <ul class="maskUl">
            <li><p>捐款合约ID：<span>300001</span></p></li>
            <li><p>捐款合约名称：<span>宁夏母亲水窖项目</span></p></li>
            <li><p>基金会：<span>中国妇女基金会母亲水窖基金委员会</span></p></li>
        </ul>
        <ul class="maskUl">
            <li><p>捐款金额限制：<span>无限制</span></p></li>
            <li><p>渠道服务费：<span>1%</span></p></li>
            <li><p>基金管理费：<span>2%</span></p></li>
        </ul>
        <ul class="maskUl">
            <li><p>合约生效时间：<span>2016年1月1日</span></p></li>
            <li><p>合约维护时间：<span>2016年1月1日</span></p></li>
        </ul>
    </div>
    <p class="close"><img src="${system.basePath}/img/common_pc/closeIcon.png" alt=""/></p>
</div>


<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
            <p class="search_con">
                <input type="text" id="search" class="search" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="#"><img src="${system.basePath}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <div class="partYi">
            <p class="partName">交易信息</p>
            <p class="partInfo"><span>交易ID</span><span class="color">${transaction.txid?if_exists}</span></p>
            <p class="partInfo"><span>交易金额</span><span>90.00 &yen;</span><span>交易已确认</span></p>
            <p class="partInfo"><span>所在区块(UUID)</span><a href="partDel.html" class="color">a49929f1ac2999e809997a49929f1ac2999e809997</a></p>
            <p class="partInfo"><span>接收时间</span><span>{transaction.tranGenTime?if_exists}</span></p>
            <p class="partInfo"><span>合约ID</span><span class="color" id="contractId">2919239123[fake]</span></p>
        </div>
        <!--tu-->
        <div class="moneyAll">
            <span class="jkr">捐款人标识</span>
            <span>90.00&yen;</span>
            <img src="${system.basePath}/img/common_pc/zhuan.png" alt="" class="zhuan"/>
            <ul class="dealMoney">
                <li><span class="lf">合约账户</span><span class="rt">89.00&yen;</span></li>
                <li><span class="lf">基金管理费账户</span><span class="rt">89.00&yen;</span></li>
                <li><span class="lf">渠道账户</span><span class="rt">89.00&yen;</span></li>
            </ul>
        </div>
        <!--序列化信息-->
        <div class="partXlh">
            <p class="partName">写入信息(区块中记录的序列化信息)</p>
            <p class="partShu">${transaction.payload?if_exists}</p>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common.js"></script>
</body>
</html>