<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_admin/logo.png" alt=""/>
            <span class="logoTxt">公益捐款 <span class="logoTxtSm">基金会版</span></span>
        </div>
        <div class="rt logoTxtSmRt">
            <p>欢迎您！${fund.name?if_exists}</p>
        </div>
        <div class="logoTxtSmRt logoAct">
           <!-- 
           		<p><img src="${system.basePath}/img/common_admin/tkIcon.png" alt=""/>提款</p>
           -->
            <p><img src="${system.basePath}/img/common_admin/tcIcon.png" alt=""/>退出</p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <!--lf-->
        <ul class="lf secLf">
            <li><a href="${system.basePath}/admin/index" class="curIcon"><img src="${system.basePath}/img/common_admin/accountIcon.png" alt=""/><span>账户概览</span></a></li>
            <li><a href="${system.basePath}/admin/myAccountBook"><img src="${system.basePath}/img/common_admin/mineIcon.png" alt=""/><span>我的账本</span></a></li>
            <li><a href="${system.basePath}/admin/donateContractList"><img src="${system.basePath}/img/common_admin/contributeIcon.png" alt=""/><span>捐献合约</span></a></li>
            <li><a href="${system.basePath}/admin/bargainItemList"><img src="${system.basePath}/img/common_admin/contractIcon.png" alt=""/><span>施工合同</span></a></li>
        </ul>
        <!--rt-->
        <div class="rt secRt">
            <!--big-->
            <div class="detailAll delAll">
                <div class="lf detailLf">
                    <p class="secImg"><img src="${system.basePath}/img/common_admin/detailIcon.png" alt=""/></p>
                    <p class="detailHyzh">基金账户</p>
                    <p class="detailYe">余额</p>
                    <p class="detailMoney">${fund.balanceStr?if_exists} ¥</p>
                    <p class="detailTk">立即提款</p>
                </div>
                <div class="lf detailRt">
                    <p  class="detailTj"><img src="${system.basePath}/img/common_admin/detailTjIcon.png" alt=""/>账户统计</p>
                    <ul class="detailUl">
                        <li><span>累计获得捐款</span><span>${fund.totalStr?if_exists} &yen;</span></li>
                        <li><span>基金管理费</span><span>[fake]99 &yen;</span></li>
                        <li><span>渠道服务费</span><span>[fake]999,999 &yen;</span></li>
                        <li><span>实收捐款</span><span>${fund.validTotalStr?if_exists} &yen;</span></li>
                    </ul>
                </div>
                <p class="delAct"><a href="${system.basePath}/admin/myAccountBook">查看明细</a></p>
                <p class="line"></p>
            </div>
            <!--sm-->
            <div class="ingAll">
                <!--lf-->
                <div class="lf ingLf">
                    <div class="detailLf">
                        <p class="secImg"><img src="${system.basePath}/img/common_admin/hyIngIcon.png" alt=""/></p>
                        <p class="detailHyzh">进行中的</p>
                        <p class="detailYe">捐款合约</p>
                        <p class="detailMoney">999 个</p>
                        <p class="ingJk">捐款合约共  999 个</p>
                    </div>
                    <p class="delAct"><a href="${system.basePath}/admin/donateContractList">查看明细</a></p>
                    <p class="line"></p>
                </div>
                <!--rt-->
                <div class="rt ingRt">
                    <div class="detailLf">
                        <p class="secImg"><img src="${system.basePath}/img/common_admin/gcIngIcon.png" alt=""/></p>
                        <p class="detailHyzh">进行中的</p>
                        <p class="detailYe">施工</p>
                        <p class="detailMoney">999 处</p>
                        <p class="ingJk">捐款合约共  999 个</p>
                    </div>
                    <p class="delAct"><a href="${system.basePath}/admin/bargainItemList">查看全部工程</a></p>
                    <p class="line"></p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script>
	$('.logoAct').click(function(){
    window.location.href="${system.basePath}/admin/login";
});

</script>
</body>
</html>